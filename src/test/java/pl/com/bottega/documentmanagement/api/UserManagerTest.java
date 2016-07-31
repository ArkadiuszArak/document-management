package pl.com.bottega.documentmanagement.api;

import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import pl.com.bottega.documentmanagement.domain.Employee;
import pl.com.bottega.documentmanagement.domain.EmployeeId;
import pl.com.bottega.documentmanagement.domain.EmployeeId_;
import pl.com.bottega.documentmanagement.domain.repositories.EmployeeRepository;

import static junit.framework.Assert.assertTrue;
import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by arkadiuszarak on 31/07/2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class UserManagerTest {

    @Mock
    private EmployeeRepository employeeRepository;

    private String occupiedLogin = "occupied login";

    private String anyPassword = "test";

    private String freeLogin = "free login";

    @Mock
    private EmployeeId anyEmployeeId;

    @Mock
    private PasswordHasher passwordHasher;

    @Mock
    private EmployeeFactory employeeFactory;

    @Mock
    private Employee employee;

    @Test
    public void shouldFailSignupWhenLoginIsOccupied(){
        //given
        UserManager userManager = new UserManager(employeeRepository, employeeFactory, passwordHasher);
        when(employeeRepository.findByEmployeeId(anyEmployeeId)).thenReturn(null);
        when(employeeRepository.isLoginOccupied(occupiedLogin)).thenReturn(true);

        //when
        SignupResultDto signeupResultDto = userManager.signup(occupiedLogin, anyPassword, anyEmployeeId);
        //then
        assertFalse(signeupResultDto.isSuccess());
        assertEquals("login is occupied", signeupResultDto.getFailureReason());
    }

    @Test
    public void shouldSignupEmployeeWhenIDandLoginAreFree(){
        //given
        UserManager userManager = new UserManager(employeeRepository, employeeFactory, passwordHasher);
        when(employeeRepository.findByEmployeeId(anyEmployeeId)).thenReturn(null);
        when(employeeRepository.isLoginOccupied(freeLogin)).thenReturn(false);
        when(employeeFactory.create(freeLogin, anyPassword, anyEmployeeId)).thenReturn(employee);

        //when
        SignupResultDto signeupResultDto = userManager.signup(freeLogin, anyPassword, anyEmployeeId);

        //then
        verify(employeeRepository).save(employee);
        assertTrue(signeupResultDto.isSuccess());
        assertNull(signeupResultDto.getFailureReason());

    }
}
