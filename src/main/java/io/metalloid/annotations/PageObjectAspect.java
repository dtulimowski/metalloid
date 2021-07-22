package io.metalloid.annotations;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.openqa.selenium.support.PageFactory;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class PageObjectAspect {
    public void initializeFindByAnnotation() {
       //PageFactory.initElements(, page);
    }
}
