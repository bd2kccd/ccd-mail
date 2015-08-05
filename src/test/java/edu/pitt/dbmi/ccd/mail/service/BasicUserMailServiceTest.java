/*
 * Copyright (C) 2015 University of Pittsburgh.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301  USA
 */
package edu.pitt.dbmi.ccd.mail.service;

import edu.pitt.dbmi.ccd.mail.CCDMailApplication;
import edu.pitt.dbmi.ccd.mail.domain.User;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * Aug 5, 2015 10:24:00 AM
 *
 * @author Kevin V. Bui (kvb2@pitt.edu)
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = CCDMailApplication.class)
public class BasicUserMailServiceTest {

    @Autowired
    private UserMailService userMailService;

    public BasicUserMailServiceTest() {
    }

    /**
     * Test of sendRegistrationActivation method, of class BasicUserMailService.
     */
    @Ignore
    @Test
    public void testSendRegistrationActivation() throws Exception {
        System.out.println("sendRegistrationActivation");
        User user = new User();
        user.setEmail("ccd.webapp@gmail.com");
        user.setFirstName("Isaac");
        user.setLastName("Newton");
        user.setUsername("inewton");

        String activationUrl = "http://localhost?activate=key";

        userMailService.sendRegistrationActivation(user, activationUrl);
    }

}
