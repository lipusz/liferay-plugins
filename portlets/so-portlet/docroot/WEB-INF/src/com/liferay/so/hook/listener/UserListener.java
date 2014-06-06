/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This file is part of Liferay Social Office. Liferay Social Office is free
 * software: you can redistribute it and/or modify it under the terms of the GNU
 * Affero General Public License as published by the Free Software Foundation,
 * either version 3 of the License, or (at your option) any later version.
 *
 * Liferay Social Office is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU Affero General Public License
 * for more details.
 *
 * You should have received a copy of the GNU General Public License along with
 * Liferay Social Office. If not, see http://www.gnu.org/licenses/agpl-3.0.html.
 */

package com.liferay.so.hook.listener;

import com.liferay.portal.ModelListenerException;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModelListener;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextThreadLocal;
import com.liferay.portal.util.PortalUtil;
import com.liferay.so.service.MemberRequestLocalServiceUtil;

import java.util.Map;

/**
 * @author Norbert Kocsis
 */
public class UserListener extends BaseModelListener<User> {

	@Override
	public void onAfterCreate(User user) throws ModelListenerException {
		try {
			ServiceContext serviceContext =
				ServiceContextThreadLocal.getServiceContext();

			if (serviceContext != null) {
				Map<String, String> headers = serviceContext.getHeaders();

				String refererUrl = headers.get("referer");

				String ppid = HttpUtil.getParameter(
					refererUrl, "p_p_id", false);

				String portletNamespace = PortalUtil.getPortletNamespace(ppid);

				String memberRequestKey = HttpUtil.getParameter(
					refererUrl, portletNamespace + "key", false);

				if (Validator.isNull(memberRequestKey)) {
					return;
				}

				MemberRequestLocalServiceUtil.updateMemberRequest(
					memberRequestKey, user.getUserId());
			}
		}
		catch (Exception e) {
			throw new ModelListenerException(e);
		}
	}

}