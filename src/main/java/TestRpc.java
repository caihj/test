import com.berbon.user.facade.AccOptFacade;
import com.pay1pay.framework.core.exception.BusinessRuntimeException;
import com.sztx.se.rpc.dubbo.consumer.DubboConsumerFactory;
import com.sztx.usercenter.rpc.api.domain.UsersVO;
import com.sztx.usercenter.rpc.api.service.QueryUserInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by Admin on 2015/12/9.
 */


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:spring-config.xml"})
public class TestRpc {


    @Autowired(required = true)
    private DubboConsumerFactory dubboConsumerFactory;



    @Test
    public void Test()
    {
        AccOptFacade opt=(AccOptFacade)dubboConsumerFactory.getDubboConsumer("accOptFacade");
        
        System.out.println("opt is" + opt);
        try {
            List l = opt.getAssociateAccounts("");
        }
        catch (RuntimeException e)
        {
            System.out.println(e.getMessage());
        }

    }

    @Test
    public void two()
    {
        QueryUserInfoService queryUserInfoService=  dubboConsumerFactory.getDubboConsumer("queryUserInfoService");
        System.out.println("queryUserInfoService is" + queryUserInfoService);
        UsersVO d=queryUserInfoService.getUserINfo("83986576");
        System.out.println("dssss is" + d);

    }

}
