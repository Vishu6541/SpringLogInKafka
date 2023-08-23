package spring.log.aspact;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ControllerAspect {
	
	
//	@Pointcut(("execution(* spring.log.controller.*.*(..))"))
//	public void controllerPointcut() {}
//	
//	
//	@Around(value = "controllerPointcut()")
//	public Object around(ProceedingJoinPoint proceedingJoinPoint) {
//		Object obj = null;
//		try {
//			System.out.println("Before method execution");
//	
//			 obj = proceedingJoinPoint.proceed();
//			 System.out.println("After method execution");
//			 System.out.println("Response: " + obj);
//		} catch (Throwable e) {
//			e.printStackTrace();
//			System.out.println("Exception genrate");
//		}
//		return obj;
//	}
//	
	
	

}
