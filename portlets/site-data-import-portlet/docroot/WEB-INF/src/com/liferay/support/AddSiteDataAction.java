/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.support;

import com.liferay.portal.DuplicateGroupException;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.events.ActionException;
import com.liferay.portal.kernel.events.SimpleAction;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.GroupConstants;
import com.liferay.portal.model.LayoutConstants;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.RoleConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.security.auth.CompanyThreadLocal;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portlet.blogs.service.BlogsEntryLocalServiceUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * @author Tibor Lipusz
 */
public class AddSiteDataAction extends SimpleAction {

	public static final String DEFAULT_BLOGS_EENTRY_TEXT = "BlogsEntry";

	public static final String DEFAULT_CHILD_SITE_NAME = "Child";

	public static long USER_ID = 20247;

	@Override
	public void run(String[] ids) throws ActionException {
		try {
			List<User> users = UserLocalServiceUtil.getCompanyUsers(
				CompanyThreadLocal.getCompanyId(), QueryUtil.ALL_POS,
				QueryUtil.ALL_POS);

			boolean adminFound = false;

			if (!ListUtil.isEmpty(users)) {
				for (User user : users) {
					for (Role role : user.getRoles()) {
						String roleName = role.getName();

						if (roleName.equals(RoleConstants.ADMINISTRATOR)) {
							USER_ID = user.getUserId();

							adminFound = true;

							break;
						}
					}

					if (adminFound) {
						break;
					}
				}
			}

			List<Group> parentGroups = new ArrayList<>();

			parentGroups.add(addSite("TestA", 4, 1));
			parentGroups.add(addSite("TestB", 49, 1));
			parentGroups.add(addSite("TestC", 499, 1));
			parentGroups.add(addSite("TestD", 999, 1));

			addUsers(parentGroups);
		}
		catch (Exception e) {
			_log.warn(e);
		}
	}

	protected static void addBlogEntries(
			long userId, Group group, int nrOfEntries)
		throws Exception {

		ServiceContext serviceContext = new ServiceContext();

		serviceContext.setScopeGroupId(group.getGroupId());
		serviceContext.setAddGroupPermissions(true);
		serviceContext.setAddGuestPermissions(true);

		String title =
			DEFAULT_BLOGS_EENTRY_TEXT + StringPool.UNDERLINE +
			group.getGroupKey() + StringPool.UNDERLINE;

		for (int i = 1; i <= nrOfEntries; i++) {
			BlogsEntryLocalServiceUtil.addEntry(
				USER_ID, title + i, DEFAULT_BLOGS_EENTRY_TEXT, serviceContext);
		}
	}

	protected static Group addSite(
			String parentSiteName, int nrOfChildSites, int nrOfEntries)
		throws Exception {

		final ServiceContext serviceContext = new ServiceContext();

		_log.info(
			"--- Creating site " + parentSiteName + " and " + nrOfChildSites +
			" child sites with " + nrOfEntries +
			" Blogs Entry in each sub-site.");

		Map<Locale, String> nameMap = new HashMap<>();

		nameMap.put(LocaleUtil.getDefault(), parentSiteName);

		final Map<Locale, String> descriptionMap = new HashMap<>();

		descriptionMap.put(LocaleUtil.getDefault(), "description");

		final boolean site = true;
		final boolean active = true;
		final boolean manualMembership = true;

		Group parentGroup = GroupLocalServiceUtil.addGroup(
			USER_ID, GroupConstants.DEFAULT_PARENT_GROUP_ID, null, 0,
			GroupConstants.DEFAULT_LIVE_GROUP_ID, nameMap, descriptionMap,
			GroupConstants.TYPE_SITE_OPEN, manualMembership,
			GroupConstants.DEFAULT_MEMBERSHIP_RESTRICTION, StringPool.BLANK,
			site, active, serviceContext);

		LayoutLocalServiceUtil.addLayout(
			USER_ID, parentGroup.getGroupId(), false,
			LayoutConstants.DEFAULT_PARENT_LAYOUT_ID, parentSiteName,
			StringPool.BLANK, StringPool.BLANK, LayoutConstants.TYPE_PORTLET,
			false, StringPool.BLANK, serviceContext);

		try {
			for (int i = 1; i <= nrOfChildSites; i++) {
				String siteName = DEFAULT_CHILD_SITE_NAME + i;

				nameMap.clear();

				nameMap.put(
					LocaleUtil.getDefault(),
					parentGroup.getGroupKey() + siteName);

				Group group = GroupLocalServiceUtil.addGroup(
					USER_ID, parentGroup.getGroupId(), null, 0,
					GroupConstants.DEFAULT_LIVE_GROUP_ID, nameMap,
					descriptionMap, GroupConstants.TYPE_SITE_OPEN,
					manualMembership,
					GroupConstants.DEFAULT_MEMBERSHIP_RESTRICTION,
					StringPool.BLANK, site, active, serviceContext);

				addBlogEntries(USER_ID, group, nrOfEntries);
			}

			_log.info("--- Action completed for site " + parentSiteName);
		}
		catch (DuplicateGroupException duplicateGroupException) {
			_log.warn("--- Site is already created and populated! ---");
		}

		return parentGroup;
	}

	protected void addUsers(List<Group> parentGroups) throws Exception {
		long companyId = CompanyThreadLocal.getCompanyId();

		ServiceContext serviceContext = new ServiceContext();

		Role siteAdminRole = RoleLocalServiceUtil.getRole(
			companyId, RoleConstants.SITE_ADMINISTRATOR);

		UserLocalServiceUtil.addUser(
			USER_ID, companyId, false, "test", "test", false, "siteAdmin",
			"admin@liferay.com", 0, StringPool.BLANK, LocaleUtil.US, "site",
			StringPool.BLANK, "admin", 0, 0, true, 1, 1, 2015, StringPool.BLANK,
			ListUtil.toLongArray(parentGroups, Group.GROUP_ID_ACCESSOR),
			new long[] {},
			new long[] {siteAdminRole.getRoleId()}, new long[] {},
			false, serviceContext);

		// Groovy-compatible

		/*
		UserLocalServiceUtil.addUser(
			USER_ID, companyId, false, "test", "test", false, "siteAdmin",
			"admin@liferay.com", 0, StringPool.BLANK, LocaleUtil.US, "site",
			StringPool.BLANK, "admin", 0, 0, true, 1, 1, 2015, StringPool.BLANK,
			ListUtil.toLongArray(parentGroups, Group.GROUP_ID_ACCESSOR),
			[] as long[], [siteAdminRole.getRoleId()] as long[], [] as long[],
			false, serviceContext);
		*/

		Role siteMemberRole = RoleLocalServiceUtil.getRole(
			companyId, RoleConstants.SITE_MEMBER);

		UserLocalServiceUtil.addUser(
			USER_ID, companyId, false, "test", "test", false, "siteMember",
			"member@liferay.com", 0, StringPool.BLANK, LocaleUtil.US, "site",
			StringPool.BLANK, "member", 0, 0, true, 1, 1, 2015,
			StringPool.BLANK,
			ListUtil.toLongArray(parentGroups, Group.GROUP_ID_ACCESSOR),
			new long[] {}, new long[] {siteMemberRole.getRoleId()},
			new long[] {}, false, serviceContext);

		// Groovy-compatible

		/*
		UserLocalServiceUtil.addUser(
			USER_ID, companyId, false, "test", "test", false, "siteMember",
			"member@liferay.com", 0, StringPool.BLANK, LocaleUtil.US, "site",
			StringPool.BLANK, "member", 0, 0, true, 1, 1, 2015,
			StringPool.BLANK,
			ListUtil.toLongArray(parentGroups, Group.GROUP_ID_ACCESSOR),
			[] as long[], [siteMemberRole.getRoleId()] as long[], [] as long[],
			false, serviceContext);
		*/
	}

	private static final Log _log = LogFactoryUtil.getLog(
		AddSiteDataAction.class);

}

// Executing as a Groovy-script

/*
(new AddSiteDataAction().run([""] as String[]))
*/