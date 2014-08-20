package com.liferay.test.antivirus;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portlet.documentlibrary.antivirus.AntivirusScannerException;
import com.liferay.portlet.documentlibrary.antivirus.BaseFileAntivirusScanner;

import java.io.File;

/**
 * 
 * @author László Hudák
 *
 */
public class FakeAntivirusScanner extends BaseFileAntivirusScanner {

	public void scan(File file) throws AntivirusScannerException,
			SystemException {

		throw new AntivirusScannerException(
			AntivirusScannerException.VIRUS_DETECTED);
	}

}