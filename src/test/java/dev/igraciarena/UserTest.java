package dev.igraciarena;

import dev.igraciarena.controller.UserController;
import dev.igraciarena.dao.UserDao;
import dev.igraciarena.exception.UserEmailAlreadyExistsException;
import dev.igraciarena.exception.UserNotFoundException;
import dev.igraciarena.model.User;
import dev.igraciarena.model.UserUpdatedRequest;
import dev.igraciarena.model.UserUpdatedResponse;
import dev.igraciarena.service.UserService;
import dev.igraciarena.service.impl.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static dev.igraciarena.utils.UserUtils.USER_STUB;
import static java.lang.Boolean.TRUE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author ivan.graciarena
 * @project CRUD
 */
class UserTest {
    private UserController userController;

    @BeforeEach
    void setUp() {
        UserDao userDao = new UserDao();
        UserService userService = new UserServiceImpl(userDao);
        userController = new UserController(userService);
    }

    @DisplayName("Testing the User object saves correctly.")
    @Test
    void testShouldSaveUserOk() {
        // arrange
        User user = USER_STUB;

        // act
        var response = userController.saveUser(user);

        // assert
        assertEquals(1, response.getUserId());
        assertEquals(user.getEmail(), response.getEmail());
    }

    @DisplayName("Testing the User object does not save correctly because of email duplication.")
    @Test
    void testShouldThrowUserAlreadyExistException() {
        // arrange
        User user = new User("Ivan", "Graciarena", "ivanigraciarena@gmail.com", "igraciarena");
        User userWithDuplicateEmail = new User("Ivan", "Graciarena", "ivanigraciarena@gmail.com", "igraciarena");

        // act
        userController.saveUser(user);

        // assert
        assertThrows(UserEmailAlreadyExistsException.class, () -> userController.saveUser(userWithDuplicateEmail));
    }

    @DisplayName("Testing the User object's id retrieves successfully.")
    @Test
    void testShouldRetrieveUserSuccessfully() {
        // arrange
        User user = USER_STUB;
        userController.saveUser(user);

        // act
        var response = userController.getUserById(1);

        // assert
        assertEquals(user.getUserName(), response.getUserName());
        assertEquals(user.getEmail(), response.getEmail());
        assertEquals(user.getName(), response.getName());
        assertEquals(user.getSureName(), response.getSureName());
    }

    @DisplayName("Testing the User object's id does not exists.")
    @Test
    void testShouldThrowsUserNotFoundException() {
        // arrange
        User user = USER_STUB;
        userController.saveUser(user);
        user.setDeleted(TRUE);

        // act and assert because of the anonymous function
        assertThrows(UserNotFoundException.class, () -> userController.getUserById(1));
    }

    @DisplayName("Testing the User object was deleted successfully.")
    @Test
    void testShouldDeleteUserOk() {
        //arrange
        User user = USER_STUB;
        userController.saveUser(user);

        // act
        userController.deleteUser(1);

        // assert
        assertThrows(UserNotFoundException.class, () -> userController.getUserById(1));
    }

    @DisplayName("Testing the User object was updated successfully.")
    @Test
    void testShouldUpdateUserOk() {
        // arrange
        User user = USER_STUB;
        userController.saveUser(user);
        UserUpdatedRequest request = new UserUpdatedRequest("ivan-graciarena", "ivan.graciarena@mango.com");

        // act
        UserUpdatedResponse response = userController.updateUser(request, "ivanigraciarena@gmail.com");

        // assert
        assertEquals(request.getUserName(), response.getUserName());
        assertEquals(request.getEmail(), response.getEmail());
        assertEquals(user.getModifiedDate(), response.getModifiedDate());
    }

    @DisplayName("Testing the User object does not update successfully because of isDeleted.")
    @Test
    void test_Should_Not_UpdateUser_And_Throws_UserNotFoundException() {
        // arrange
        User user = USER_STUB;
        userController.saveUser(user);
        user.setDeleted(TRUE);
        UserUpdatedRequest request = new UserUpdatedRequest("ivan-graciarena", "ivan.graciarena@mango.com");

        // act and assert because of the anonymous function
        assertThrows(UserNotFoundException.class,
                () -> userController.updateUser(request, "ivanigraciarena@mango.com"));
    }
}
