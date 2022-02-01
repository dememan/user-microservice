package com.edu.miu.eaproject.userservice.aspect;

import com.edu.miu.eaproject.userservice.domain.Audit;
import com.edu.miu.eaproject.userservice.domain.Users;
import com.edu.miu.eaproject.userservice.repository.AuditRepository;
import com.edu.miu.eaproject.userservice.service.UsersService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.discovery.converters.Auto;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.time.LocalDateTime;

@Aspect
@Component
public class AuditAspect {

    @Autowired
    private AuditRepository auditRepository;

    @Autowired
    private UsersService usersService;

    @Around("@annotation(Auditable)")
    public void auditUser(ProceedingJoinPoint pjp) {
        System.out.println("audit started");
        try {
            Audit audit = new Audit();
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes())
                .getRequest();
            Users newUser=null;
            Users returnedUser=null;
            System.out.println(request.getMethod());
            if(request.getMethod().equalsIgnoreCase("PUT")) {
                audit.setOldValue(new ObjectMapper().writeValueAsString(usersService.getById((Long) pjp.getArgs()[1])));
                newUser = (Users) pjp.getArgs()[0];
                returnedUser = (Users) pjp.proceed();
            }
            else  if(request.getMethod().equalsIgnoreCase("POST")) {
                audit.setOldValue(null);
                newUser = (Users) pjp.getArgs()[0];
                returnedUser = (Users) pjp.proceed();
            }
            else  if(request.getMethod().equalsIgnoreCase("DELETE")) {
                audit.setOldValue(new ObjectMapper().writeValueAsString(usersService.getById((Long) pjp.getArgs()[0])));
                 pjp.proceed();
            }
            audit.setUser(returnedUser);
            audit.setCreatedAt(LocalDateTime.now());
            audit.setMethod(request.getMethod());
            audit.setRequestURL(request.getScheme()+"://"+request.getRemoteAddr()+":"+ request.getServerPort() +request.getRequestURI());
            audit.setRequest(new ObjectMapper().writeValueAsString(newUser));
            audit.setResponse(new ObjectMapper().writeValueAsString(returnedUser));
            audit.setCreatedBy(request.getUserPrincipal()==null?"system":request.getUserPrincipal().getName());

            auditRepository.save(audit);

        } catch (Throwable e) {
            e.printStackTrace();
        }

    }

}
