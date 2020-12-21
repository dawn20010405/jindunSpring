/**
 * @ Author     ：彭欣雨
 * @ Date       ：Created in 16:35 2020-12-21
 * @ Description：emp员工表 PxyempServices
 */
package com.demo.Services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Auther: Administrator
 * @Date: 2020-12-21 16:35
 * @Description:
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class PxyempServices {
}
