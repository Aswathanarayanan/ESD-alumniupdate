import axios from 'axios'

// The API endpoint where login data is sent to
const OrgaddUrl = `http://localhost:8080/esd-project-1.0-SNAPSHOT/api/alumniorganisation/add`

const orgadd = async (details,user,organisation) => {
  // Send the login credential data to the loginBaseUrl API endpoint as an HTTP POST request
  // Note the async-await
  const response = await axios.post(`${OrgaddUrl}?id=${user.id}&org=${organisation}`, details)
  
  // Return .data field of the response object which would contain the logged in user object
  // And the user state would now be updated by the handleLogin() method
  return response.data
}

const OrgaddUrl1 = `http://localhost:8080/esd-project-1.0-SNAPSHOT/api/alumniorganisation/update`

const orgupd = async (details,organisation) => {
  // Send the login credential data to the loginBaseUrl API endpoint as an HTTP POST request
  // Note the async-await
  const response = await axios.post(`${OrgaddUrl1}?id=${organisation}`, details)
  
  // Return .data field of the response object which would contain the logged in user object
  // And the user state would now be updated by the handleLogin() method
  return response.data
}

const OrgaddUrl2 = `http://localhost:8080/esd-project-1.0-SNAPSHOT/api/alumniorganisation/delete`

const orgdel = async (organisation) => {
  // Send the login credential data to the loginBaseUrl API endpoint as an HTTP POST request
  // Note the async-await
  const response = await axios.post(`${OrgaddUrl2}?id=${organisation}`)
  
  // Return .data field of the response object which would contain the logged in user object
  // And the user state would now be updated by the handleLogin() method
  return response.data
}
// Export the method as an object so that it can be accessible outside this file as a service
const exportObject = { orgadd ,orgupd ,orgdel}
export default exportObject