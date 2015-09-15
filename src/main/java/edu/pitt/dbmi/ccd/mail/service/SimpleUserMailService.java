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

import edu.pitt.dbmi.ccd.mail.AbstractBasicMail;
import java.util.Locale;
import javax.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring4.SpringTemplateEngine;

/**
 *
 * Sep 15, 2015 8:53:06 AM
 *
 * @author Kevin V. Bui (kvb2@pitt.edu)
 */
@Service
public class SimpleUserMailService extends AbstractBasicMail implements UserBasicMailService {

    protected static final Locale LOCALE = new Locale("en", "US");

    protected final SpringTemplateEngine templateEngine;

    @Autowired(required = true)
    public SimpleUserMailService(SpringTemplateEngine templateEngine, JavaMailSender javaMailSender) {
        super(javaMailSender);
        this.templateEngine = templateEngine;
    }

    @Override
    public void sendRegistrationActivation(String username, String email, String activationUrl) throws MessagingException {
        Context context = new Context(LOCALE);
        context.setVariable("username", username);
        context.setVariable("email", email);
        context.setVariable("activationUrl", activationUrl);

        String to = email;
        String subject = "CCD Account Activation";
        String body = this.templateEngine.process("email/registration-activation", context);
        boolean html = true;
        send(to, subject, body, html);
    }

}
