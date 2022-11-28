import React, { useState } from 'react'
import OrglistService from "../services/orglist"
/*
  This component is used for rendering the "Bills" view which contains each Bill of the Student
  Each Bill is its own component
  
  bills: Collection of bills of the given Student
  payBill: Method that uses the axios service to pay the specified bill, i.e. send a DELETE request
*/
const Organization = ({ updateorg ,list }) => {  
  // If there's no Bills for the student, then render nothing. Can instead render a message like "No Bills Remaining"

  const [ position, setposition ] = useState('')
  const [ joingdate, setjoingdate ] = useState('')
  const [ leavingdate, setleavingdate ] = useState('')
  const [ organisation, setorganisation ] = useState('')
//   const handleChange = (event) =>{
//     setorganisation(event.target.value);
//   }
  const Organizationhandle = (event) => {
    // Preventing default submission of the form to the action attribute URL
    event.preventDefault()

    const details = {
      position,joingdate,leavingdate
    }

    // Calling startLogin with the provided credentials that will make a call to the backend
    updateorg(details,organisation)

    // Reset the form state, i.e. the text that's on the username and password text boxes to empty strings
    // setposition('')
    // setjoingdate('')
    // setleavingdate('')
    // setorganisation('')
  }
  return (
    <div>
    <h3>Update Organisation Details</h3>
    <h5>Add</h5>
    <form onSubmit={Organizationhandle} id='org1-form'>
      <input 
        type='position'
        placeholder='position'
        // Note that the text that's displayed on the textbox (value attribute) is controlled by the email state
        value={position}
        // onChange event handler
        // When you type something on the textbox, the onChange event handler will be triggered
        // This event handler as written below, updates the email state with what's being typed by the user
        // Because a state has been updated, the form component will be re-rendered and you can see the updated input
        // on the screen, obviously this happens so fast that you cannot see it but this is the entire procedure
        onChange={event => setposition(event.target.value)}
        id='position'
        required
      />
        
      {/* Same as the above username input, except this one has the type password */}
      <input
        type='joingdate'
        placeholder='joingdate'
        value={joingdate}
        onChange={event => setjoingdate(event.target.value)}
        id='joingdate'
        required
      />

      <input
        type='leavingdate'
        placeholder='leavingdate'
        value={leavingdate}
        onChange={event => setleavingdate(event.target.value)}
        id='leavingdate'
        required
      />

      {/* {list.forEach(value => {
            <option>{value.name}</option>;
        })} */}

      <label>Organisation:</label>
      <select value ={organisation} onChange={event => setorganisation(event.target.value)}>
        {list.map((org) => {
            return<option value={org.id} key={org.id}>{org.name}</option>
        })}
        {/* <option>1</option>
        <option>2</option>
        <option>3</option> */}
      </select>
      {/* Submit button for the form */}
      <br></br>
      <button type='submit' id='org-submit'>ADD</button>
    </form>
    </div>
  )
}

export default Organization