package com.sticker.operaSales.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class NotifierAspect {

    @Pointcut("@annotation(com.sticker.operaSales.annotations.Notifier)")
    public void sendMessage(){}

    @Around("sendMessage()")
    public void sendMessageAround(ProceedingJoinPoint point) {

        print("Был запущен " + point.getSignature().getName() + "()");

        try {
            point.proceed();
            print("успешно " + point.getSignature().getName() + "()");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            print("Неудачно с " + point.getSignature().getName() + "()");
        }
    }

    private void print(Object o) {
        System.out.println(o);
    }
}
