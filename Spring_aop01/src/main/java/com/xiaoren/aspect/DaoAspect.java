package com.xiaoren.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.lang.annotation.Retention;
import java.util.Arrays;

@Aspect
@Component
public class DaoAspect {
    //定义一个公共切入点addPointCut
    @Pointcut("execution(* com.xiaoren.dao.*.add*(..))")
    public void addPointCut() {
    }

    /*
     * 前置通知: 切点方法执行之前先执行的功能
     * 参数列表可以用JoinPoint接收切点对象
     * 可以获取方法执行的参数
     * */
    @Before("addPointCut()")
    public void methodBefore(JoinPoint jot) {
        Object[] args = jot.getArgs();
        System.out.println("args:" + Arrays.toString(args));
        System.out.println("before invoked  ....");
    }

    /*
     * 后置通知:方法执行之后要增强的功能
     * 无论切点方法是否出现异常都会执行的方法
     * 参数列表可以用JoinPoint接收切点对象
     * */
    @After("addPointCut()")
    public void methodAfter(JoinPoint joinPoint) {
        System.out.println("methodAfter invoked .....");
    }

    /*
     * 返回通知:切点方法正常运行结束后增强的功能
     * 如果方法运行过程中出现异常,则该功能不运行
     * 参数列表可以用 JoinPoint joinPoint接收切点对象
     * 可以用Object res接收方法返回值,需要用returning指定返回值名称
     * */
    @AfterReturning(value = "addPointCut()", returning = "re")
    public void methodAfterReturning(JoinPoint joinPoint, Object re) {
        System.out.println("method AfterReturning invoked ....");
        System.out.println("接收返回值：" + re);
    }

    /*
     * 异常通知:切点方法出现异常时运行的增强功能
     * 如果方法运行没有出现异常,则该功能不运行
     * 参数列表可以用Exception ex接收异常对象 需要通过throwing指定异常名称
     * */
    @AfterThrowing(value = "addPointCut()", throwing = "ex")
    public void methodAfterThrowing(Exception ex) {
        System.out.println("出现异常。。。。");
        System.out.println(ex);
    }

    /*环绕通知:在切点方法之前和之后都进行功能的增强
     * 需要在通知中定义方法执行的位置,并在执行位置之前和之后自定义增强的功能
     * 方法列表可以通过ProceedingJoinPoint获取执行的切点
     * 通过proceedingJoinPoint.proceed()方法控制切点方法的执行位置
     * proceedingJoinPoint.proceed()方法会将切点方法的返回值获取到,并交给我们,可以做后续处理
     * 我们在环绕通知的最后需要将切点方法的返回值继续向上返回,否则切点方法在执行时接收不到返回值
     * */
    @Around("addPointCut()")
    public Object methodAround(ProceedingJoinPoint proceedingJoinPoint) {

        Object proceed = null;
        try {
            System.out.println("环绕前.....");
            proceed = proceedingJoinPoint.proceed();//控制切入点方法在这里执行
            System.out.println("环绕后/........");
        } catch (Throwable e) {
            e.printStackTrace();
        } finally {
            return proceed;
        }
    }
}

