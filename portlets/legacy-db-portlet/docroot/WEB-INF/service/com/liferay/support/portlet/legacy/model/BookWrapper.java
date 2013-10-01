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

package com.liferay.support.portlet.legacy.model;

import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Book}.
 * </p>
 *
 * @author    Tibor Lipusz
 * @see       Book
 * @generated
 */
public class BookWrapper implements Book, ModelWrapper<Book> {
	public BookWrapper(Book book) {
		_book = book;
	}

	public Class<?> getModelClass() {
		return Book.class;
	}

	public String getModelClassName() {
		return Book.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("bookId", getBookId());
		attributes.put("bookName", getBookName());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Long bookId = (Long)attributes.get("bookId");

		if (bookId != null) {
			setBookId(bookId);
		}

		String bookName = (String)attributes.get("bookName");

		if (bookName != null) {
			setBookName(bookName);
		}
	}

	/**
	* Returns the primary key of this book.
	*
	* @return the primary key of this book
	*/
	public long getPrimaryKey() {
		return _book.getPrimaryKey();
	}

	/**
	* Sets the primary key of this book.
	*
	* @param primaryKey the primary key of this book
	*/
	public void setPrimaryKey(long primaryKey) {
		_book.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the book ID of this book.
	*
	* @return the book ID of this book
	*/
	public long getBookId() {
		return _book.getBookId();
	}

	/**
	* Sets the book ID of this book.
	*
	* @param bookId the book ID of this book
	*/
	public void setBookId(long bookId) {
		_book.setBookId(bookId);
	}

	/**
	* Returns the book name of this book.
	*
	* @return the book name of this book
	*/
	public java.lang.String getBookName() {
		return _book.getBookName();
	}

	/**
	* Sets the book name of this book.
	*
	* @param bookName the book name of this book
	*/
	public void setBookName(java.lang.String bookName) {
		_book.setBookName(bookName);
	}

	public boolean isNew() {
		return _book.isNew();
	}

	public void setNew(boolean n) {
		_book.setNew(n);
	}

	public boolean isCachedModel() {
		return _book.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_book.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _book.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _book.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_book.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _book.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_book.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new BookWrapper((Book)_book.clone());
	}

	public int compareTo(com.liferay.support.portlet.legacy.model.Book book) {
		return _book.compareTo(book);
	}

	@Override
	public int hashCode() {
		return _book.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.liferay.support.portlet.legacy.model.Book> toCacheModel() {
		return _book.toCacheModel();
	}

	public com.liferay.support.portlet.legacy.model.Book toEscapedModel() {
		return new BookWrapper(_book.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _book.toString();
	}

	public java.lang.String toXmlString() {
		return _book.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_book.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public Book getWrappedBook() {
		return _book;
	}

	public Book getWrappedModel() {
		return _book;
	}

	public void resetOriginalValues() {
		_book.resetOriginalValues();
	}

	private Book _book;
}