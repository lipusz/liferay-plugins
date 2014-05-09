package com.test;

import com.liferay.portal.service.CompanyLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

import javax.portlet.PortletException;

public class NewPortlet extends MVCPortlet {

    private static int COUNTER = 0;

    @Override
    public void init() throws PortletException {
        super.init();
        String webId = "bosch" + COUNTER++ + ".com";
        try {
            while (CompanyLocalServiceUtil.getCompanyByWebId(webId) != null) {
                webId = "bosch" + COUNTER++ + ".com";
            }
        } catch (final Exception e1) {
            try {
                CompanyLocalServiceUtil.addCompany(webId, webId, webId, webId, false, 0, true);
            } catch (final Exception e) {
                e.printStackTrace();
            }
        }
    }

}
