import axios from 'axios'

// The API endpoint where login data is sent to
const EduUpdateUrl = `http://localhost:8080/esd-project-1.0-SNAPSHOT/api/alumnieducation/update`

const updateedu = async (details,user) => {
  // Send the login credential data to the loginBaseUrl API endpoint as an HTTP POST request
  // Note the async-await
  const response = await axios.post(`${EduUpdateUrl}?id=${user.id}`, details)
  
  // Return .data field of the response object which would contain the logged in user object
  // And the user state would now be updated by the handleLogin() method
  return response.data
}

// Export the method as an object so that it can be accessible outside this file as a service
const exportObject = { updateedu }
export default exportObject