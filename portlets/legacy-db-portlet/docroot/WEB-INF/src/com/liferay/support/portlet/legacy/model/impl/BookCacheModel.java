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

package com.liferay.support.portlet.legacy.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.liferay.support.portlet.legacy.model.Book;

import java.io.Serializable;

/**
 * The cache model class for representing Book in entity cache.
 *
 * @author Tibor Lipusz
 * @see Book
 * @generated
 */
public class BookCacheModel implements CacheModel<Book>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{bookId=");
		sb.append(bookId);
		sb.append(", bookName=");
		sb.append(bookName);
		sb.append("}");

		return sb.toString();
	}

	public Book toEntityModel() {
		BookImpl bookImpl = new BookImpl();

		bookImpl.setBookId(bookId);

		if (bookName == null) {
			bookImpl.setBookName(StringPool.BLANK);
		}
		else {
			bookImpl.setBookName(bookName);
		}

		bookImpl.resetOriginalValues();

		return bookImpl;
	}

	public long bookId;
	public String bookName;
}