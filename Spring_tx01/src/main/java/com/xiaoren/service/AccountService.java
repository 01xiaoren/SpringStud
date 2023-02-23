package com.xiaoren.service;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * PROPAGATION_REQUIRED(默认不写)
 * 如果add方法有事务,那么addDept和addEmp就加入到add方法里的事务
 * 如果add方法没有事务,那么就新建一个事务,将addDept和addEmp加入到这个新的事务中
 * <p>
 * PROPAGATION_REQUIRES_NEW
 * 无论add是否有事务,都建立一个新的事务,所有的方法都加入到新的事务中,add原来的事务就不用了
 */
//事务一般在接口中
//@Transactional//当前接口的所有方法

/**
 * isolation 事务的隔离级别
 * 1) DEFAULT （默认）
 * 2) READ_UNCOMMITTED （读未提交）
 * 3) READ_COMMITTED （读已提交）
 * 4) REPEATABLE_READ （可重复读）
 * 5) SERIALIZABLE（串行化）
 *
 * timeout 超时时间
 * 事务一定要在多长时间之内提交,如果不提交就会回滚
 *
 * readOnly 只读事务
 * 事务是否只能读取数据库的数据,如果为true,则不允许进行增删改
 *
 * rollbackFor 指定发生回滚的异常
 * 当方法发生哪些异常时才会回滚
 *
 * noRollbackFor 指定不发生回滚的异常
 * 当方法发生哪些异常时,不会回滚
 */
public interface AccountService {
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
//仅仅只当前方法
    int transMoney(int from, int to, int money);
}
