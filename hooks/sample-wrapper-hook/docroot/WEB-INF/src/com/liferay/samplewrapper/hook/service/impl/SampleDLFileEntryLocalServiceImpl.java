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

package com.liferay.samplewrapper.hook.service.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalService;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceWrapper;

import java.io.InputStream;

/**
 * @author Tibor Lipusz | Senior Technical Engineer
 */
public class SampleDLFileEntryLocalServiceImpl
		extends DLFileEntryLocalServiceWrapper {

	public SampleDLFileEntryLocalServiceImpl(
			DLFileEntryLocalService dlFileEntryLocalService) {

		super(dlFileEntryLocalService);
	}

	@Override
	public InputStream getFileAsStream(
			long fileEntryId, String version, boolean incrementCounter)
		throws PortalException {

		_log.debug("#getFileAsStream | Invoked");

		// Add watermark to downloaded files

		return super.getFileAsStream(fileEntryId, version, incrementCounter);
	}

	@Override
	public DLFileEntry getFileEntry(long fileEntryId) throws PortalException {
		_log.debug("#getFileEntry | Invoked");

		return super.getFileEntry(fileEntryId);
	}

	private static Log _log = LogFactoryUtil.getLog(
		SampleDLFileEntryLocalServiceImpl.class);

}