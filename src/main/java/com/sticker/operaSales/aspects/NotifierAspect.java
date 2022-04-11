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

        print("Запускаю " + point.getSignature().getName() + "()");

        try {
            point.proceed();
            print("Всё ок " + point.getSignature().getName() + "()");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            print("Ошибочка вышла " + point.getSignature().getName() + "()");
        }
    }

    private void print(Object o) {
        System.out.println(o);
    }
}
