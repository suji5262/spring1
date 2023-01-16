package org.zerock.w2.listener;

import lombok.extern.log4j.Log4j2;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

@WebListener
@Log4j2
public class LoginListener implements HttpSessionAttributeListener {

    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        // HttpSession 이 생성되거나 setAttribute()등의 작업이 이루어질 때 감지

        String name = event.getName();

        Object obj = event.getValue();

        if (name.equals("loginInfo")) {
            log.info("A user logined...............");
            log.info(obj);
        }
    }
}
