/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */

package com.liferay.hook.portlet.documentlibrary.util;

import java.io.InputStream;
import java.util.List;

import com.liferay.portal.kernel.lar.PortletDataContext;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.FileVersion;
import com.liferay.portal.kernel.xml.Element;
import com.liferay.portlet.documentlibrary.util.DLPreviewableProcessor;
import com.liferay.portlet.documentlibrary.util.PDFProcessor;

/**
 * @author Tibor Lipusz
 */
public class CustomPDFProcessorImpl
	extends DLPreviewableProcessor implements PDFProcessor {

	@Override
	public void afterPropertiesSet()
		throws Exception {

		// TODO Auto-generated method stub
		
	}

	@Override
	public void generateImages(
		FileVersion sourceFileVersion, FileVersion destinationFileVersion)
		throws Exception {

		// TODO Auto-generated method stub
		
	}

	@Override
	public InputStream getPreviewAsStream(FileVersion fileVersion, int index)
		throws Exception {

		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getPreviewFileCount(FileVersion fileVersion) {

		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long getPreviewFileSize(FileVersion fileVersion, int index)
		throws Exception {

		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public InputStream getThumbnailAsStream(FileVersion fileVersion, int index)
		throws Exception {

		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getThumbnailFileSize(FileVersion fileVersion, int index)
		throws Exception {

		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean hasImages(FileVersion fileVersion) {

		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isDocumentSupported(FileVersion fileVersion) {

		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isDocumentSupported(String mimeType) {

		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isSupported(String mimeType) {

		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void doExportGeneratedFiles(
		PortletDataContext portletDataContext, FileEntry fileEntry,
		Element fileEntryElement)
		throws Exception {

		// TODO Auto-generated method stub
		
	}

	@Override
	protected void doImportGeneratedFiles(
		PortletDataContext portletDataContext, FileEntry fileEntry,
		FileEntry importedFileEntry, Element fileEntryElement)
		throws Exception {

		// TODO Auto-generated method stub
		
	}

	@Override
	protected List<Long> getFileVersionIds() {

		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String getPreviewType(FileVersion fileVersion) {

		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String getThumbnailType(FileVersion fileVersion) {

		// TODO Auto-generated method stub
		return null;
	}

		
}