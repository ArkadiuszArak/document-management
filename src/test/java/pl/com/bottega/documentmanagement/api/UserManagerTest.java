package pl.com.bottega.documentmanagement.api;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import pl.com.bottega.documentmanagement.domain.Employee;
import pl.com.bottega.documentmanagement.domain.EmployeeId;
import pl.com.bottega.documentmanagement.domain.repositories.EmployeeRepository;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by maciuch on 31.07.16.
 */
@RunWith(MockitoJUnitRunner.class)
public class UserManagerTest {

    @Mock
    private EmployeeRepository employeeRepository;

    private String occupiedLogin = "occupied login";
    private String freeLogin = "free login";
    private String anyPassword = "test";
    private String testLogin = "test Login";
    private String wrongPassword = "wrong one";

    @Mock
    private EmployeeId anyEmployeeId;

    @Mock
    private PasswordHasher passwordHasher;

    @Mock
    private EmployeeFactory employeeFactory;

    @Mock
    private Employee employee;

    @Test
    public void shouldFailSignupWhenLoginIsOccupied() {
        // given
        UserManager userManager = new UserManager(employeeRepository, employeeFactory, passwordHasher);
        when(employeeRepository.findByEmployeeId(anyEmployeeId)).thenReturn(null);
        when(employeeRepository.isLoginOccupied(occupiedLogin)).thenReturn(true);

        // when
        SignupResultDto signupResultDto = userManager.signup(occupiedLogin, anyPassword, anyEmployeeId);

        // then
        assertFalse(signupResultDto.isSuccess());
        assertEquals("login is occupied", signupResultDto.getFailureReason());
    }

    @Test
    public void shouldSignupEmployeeWhenIdAndLoginAreFree() {
        // given
        UserManager userManager = new UserManager(employeeRepository, employeeFactory, passwordHasher);
        when(employeeRepository.findByEmployeeId(anyEmployeeId)).thenReturn(null);
        when(employeeRepository.isLoginOccupied(freeLogin)).thenReturn(false);
        when(employeeFactory.create(freeLogin, anyPassword, anyEmployeeId)).thenReturn(employee);

        // when
        SignupResultDto signupResultDto = userManager.signup(freeLogin, anyPassword, anyEmployeeId);

        // then
        verify(employeeRepository).save(employee);
        assertTrue(signupResultDto.isSuccess());
        assertNull(signupResultDto.getFailureReason());
    }

    @Test
    public void shouldFailWhenEmployeeAlreadyRegistered(){
        UserManager userManager = new UserManager(employeeRepository, employeeFactory, passwordHasher);
        when(employeeRepository.findByEmployeeId(anyEmployeeId)).thenReturn(employee);
        when(employee.isRegistered()).thenReturn(true);

        SignupResultDto signupResultDto = userManager.signup(freeLogin, anyPassword, anyEmployeeId);

        assertEquals("employee registered", signupResultDto.getFailureReason());
    }

    @Test
    public void shouldSetupAccount(){
        UserManager userManager = new UserManager(employeeRepository, employeeFactory, passwordHasher);
        when(employeeRepository.findByEmployeeId(anyEmployeeId)).thenReturn(employee);
        when(employee.isRegistered()).thenReturn(false);
        employee.setupAccount(freeLogin, anyPassword);

        SignupResultDto signupResultDto = userManager.signup(freeLogin, anyPassword, anyEmployeeId);

        verify(employeeRepository).save(employee);
        assertTrue(signupResultDto.isSuccess());
        assertNull(signupResultDto.getFailureReason());
    }

    @Test
    public void shouldLoginWhenLoginAndPasswordAreCorrect(){
        //given
        UserManager userManager = new UserManager(employeeRepository, employeeFactory, passwordHasher);
        when(employeeRepository.findByLoginAndPassword(testLogin, passwordHasher.hashedPassword(anyPassword))).thenReturn(employee);

        //when
        SignupResultDto signupResultDto = userManager.login(testLogin, anyPassword);

        //then
        assertTrue(signupResultDto.isSuccess());
        assertNull(signupResultDto.getFailureReason());
    }

    @Test
    public void shouldNotLoginWhenLoginOrPasswordIncorrect(){
        //given
        UserManager userManager = new UserManager(employeeRepository, employeeFactory, passwordHasher);
        when(employeeRepository.findByLoginAndPassword(testLogin, passwordHasher.hashedPassword(anyPassword))).thenReturn(null);

        //when
        SignupResultDto signupResultDto = userManager.login(testLogin, anyPassword);

        //then
        assertFalse(signupResultDto.isSuccess());
        assertEquals("login or password incorrect", signupResultDto.getFailureReason());
    }
}
