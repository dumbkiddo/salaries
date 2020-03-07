package kz.iitu.salaries.spring.event.handler;

import kz.iitu.salaries.spring.event.NotifyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class NotifyEventHandler implements ApplicationListener<NotifyEvent> {

    @Override
    public void onApplicationEvent(NotifyEvent notifyEvent) {
        System.out.println("Notification\n" + notifyEvent.getEmployee() + "'s salary has changed");
    }
}
