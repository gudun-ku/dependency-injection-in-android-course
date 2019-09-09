package com.techyourchance.journeytodependencyinjection.common.dependencyinjection;

import com.techyourchance.journeytodependencyinjection.common.dependencyinjection.presentation.PresentationComponent;
import com.techyourchance.journeytodependencyinjection.questions.FetchQuestionDetailsUseCase;
import com.techyourchance.journeytodependencyinjection.questions.FetchQuestionsListUseCase;
import com.techyourchance.journeytodependencyinjection.screens.common.dialogs.DialogsManager;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class Injector {
    private final PresentationComponent mPresentationComponent;

    public Injector(PresentationComponent presentationComponent) {
        mPresentationComponent = presentationComponent;
    }

    public void inject(Object client) {
        Class clentClass = client.getClass();
        Field[] fields = clentClass.getDeclaredFields();

        for (Field field: fields) {
            if (isAnnotatedForInjection(field)) {
                injectField(client, field);
            }
        }
    }

    private boolean isAnnotatedForInjection(Field field) {
        Annotation[] annotations = field.getDeclaredAnnotations();

        for (Annotation annotation : annotations) {
            if (annotation instanceof Service) {
                return true;
            }
        }

        return false;
    }

    private void injectField(Object client, Field field) {
        try {
            boolean isAccessibleInitially = field.isAccessible();
            field.setAccessible(true);
            field.set(client, getServiceForClass(field.getType()));
            field.setAccessible(isAccessibleInitially);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    private Object getServiceForClass(Class<?> type) {
        if (type.equals(DialogsManager.class)) {
            return mPresentationComponent.getDialogsManager();
        }
        else if (type.equals(ViewMvcFactory.class)) {
            return mPresentationComponent.getViewMvcFactory();
        }
        else if (type.equals(FetchQuestionsListUseCase.class)) {
            return mPresentationComponent.getFetchQuestionsListUseCase();
        }
        else if (type.equals(FetchQuestionDetailsUseCase.class)) {
            return mPresentationComponent.getFetchQuestionDetailsUseCase();
        }
        else {
            throw new RuntimeException("unsupported service type class: " + type);
        }
    }

}
