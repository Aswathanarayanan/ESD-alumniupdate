import React, { useState } from 'react'
/*
  This component is used for rendering the "Bills" view which contains each Bill of the Student
  Each Bill is its own component
  
  bills: Collection of bills of the given Student
  payBill: Method that uses the axios service to pay the specified bill, i.e. send a DELETE request
*/
const Organisationdelete = ({ orgdelete ,list }) => {  
  // If there's no Bills for the student, then render nothing. Can instead render a message like "No Bills Remaining"

  const [ organisation, setorganisation ] = useState('')
  const Organizationhandle = (event) => {
    // Preventing default submission of the form to the action attribute URL
    event.preventDefault()
    // Calling startLogin with the provided credentials that will make a call to the backend
    orgdelete(organisation)

    // Reset the form state, i.e. the text that's on the username and password text boxes to empty strings
    // setposition('')
    // setjoingdate('')
    // setleavingdate('')
    // setorganisation('')
  }
  return (
    <div>
    <h5>Delete</h5>
    <form onSubmit={Organizationhandle} id='org1-form'>
    <label>Postion and Organisation to delete:</label>
      <select value ={organisation} onChange={event => setorganisation(event.target.value)}>
        {list.map((org) => {
            return<option value={org.id} key={org.id}>{org.position}-{org.organisation.name}</option>
        })}
        {/* <option>1</option> */}
      </select>
      <button type='submit' id='org-submit'>DELETE</button>
    </form>
    </div>
  )
}

export default Organisationdelete