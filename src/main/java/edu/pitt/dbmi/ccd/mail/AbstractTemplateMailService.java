/*
 * Copyright (C) 2018 University of Pittsburgh.
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
package edu.pitt.dbmi.ccd.mail;

import java.util.Locale;
import java.util.Map;
import javax.mail.MessagingException;
import org.springframework.mail.javamail.JavaMailSender;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

/**
 * An abstract class for sending email using templates.
 *
 * Mar 30, 2018 11:59:18 AM
 *
 * @author Kevin V. Bui (kvb2@pitt.edu)
 */
public abstract class AbstractTemplateMailService extends AbstractMailService {

    protected static final Locale LOCALE = new Locale("en", "US");

    protected final SpringTemplateEngine templateEngine;

    public AbstractTemplateMailService(SpringTemplateEngine templateEngine, JavaMailSender mailSender) {
        super(mailSender);
        this.templateEngine = templateEngine;
    }

    protected void sendMail(Object templateData, String template, String subject, String... to) throws MessagingException {
        Context context = new Context(LOCALE);
        context.setVariable("email", templateData);

        String body = this.templateEngine.process(template, context);

        send(to, subject, body, true);
    }

    protected void sendMail(Map<String, Object> variables, String template, String subject, String... to) throws MessagingException {
        Context context = new Context(LOCALE);
        context.setVariables(variables);

        String body = this.templateEngine.process(template, context);

        send(to, subject, body, true);
    }

}
