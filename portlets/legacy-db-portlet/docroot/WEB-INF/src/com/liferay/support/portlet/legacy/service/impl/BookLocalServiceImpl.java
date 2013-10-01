/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
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

package com.liferay.support.portlet.legacy.service.impl;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.support.portlet.legacy.model.Book;
import com.liferay.support.portlet.legacy.service.base.BookLocalServiceBaseImpl;

import java.util.List;

/**
 * The implementation of the book local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.support.portlet.legacy.service.BookLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Tibor Lipusz
 * @see com.liferay.support.portlet.legacy.service.base.BookLocalServiceBaseImpl
 * @see com.liferay.support.portlet.legacy.service.BookLocalServiceUtil
 */
public class BookLocalServiceImpl extends BookLocalServiceBaseImpl {

	public List<Book> getBooks() throws SystemException {
		return bookPersistence.findAll();
	}
}