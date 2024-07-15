import { render, fireEvent, screen } from '@testing-library/react'; // Import necessary testing utilities
import Login from '../components/Login'; // Import the Login component
import { BrowserRouter } from 'react-router-dom'; // Import BrowserRouter for routing

// Describe the test suite for the Login component
describe('Login component', () => {
  
  // Test case to ensure users can input username or email
  it('allows users to input username or email', async () => {
    const { getByPlaceholderText } = render(
      // Render the Login component wrapped in BrowserRouter
      <BrowserRouter>
        <Login />
      </BrowserRouter>
    );
    
    // Get the username or email input field
    const usernameOrEmailInput = getByPlaceholderText('Username or Email');

    // Simulate user input by changing the input value
    fireEvent.change(usernameOrEmailInput, { target: { value: 'testuser' } });

    // Assert that the input value matches the entered value
    expect(usernameOrEmailInput.value).toBe('testuser');
  });

  // Test case to ensure users can input password
  it('allows users to input password', async () => {
    const { getByPlaceholderText } = render(
      // Render the Login component wrapped in BrowserRouter
      <BrowserRouter>
        <Login />
      </BrowserRouter>
    );
    
    // Get the password input field
    const passwordInput = getByPlaceholderText('Password');

    // Simulate user input by changing the input value
    fireEvent.change(passwordInput, { target: { value: 'testpassword' } });  // fireEvent simulates user interactions like clicks or changes on DOM elements in testing.
                                                                            // It's useful for testing event handlers, state changes, and component rendering in React tests.

    // Assert that the input value matches the entered value
    expect(passwordInput.value).toBe('testpassword');
  });

  // Test case to ensure login form is submitted when login button is clicked
  it('submits login form when login button is clicked', async () => {
    const { getByPlaceholderText, getByRole } = render(
      // Render the Login component wrapped in BrowserRouter
      <BrowserRouter>
        <Login />
      </BrowserRouter>
    );

    // Get the username/email, password input fields, and login button
    const usernameOrEmailInput = getByPlaceholderText('Username or Email');
    const passwordInput = getByPlaceholderText('Password');
    const loginButton = getByRole('button', { name: 'Login' });

    // Simulate user input by changing the input values
    fireEvent.change(usernameOrEmailInput, { target: { value: 'mike' } });
    fireEvent.change(passwordInput, { target: { value: 'mike@123' } });

    // Simulate click event on the login button
    fireEvent.click(loginButton);
  });
});
