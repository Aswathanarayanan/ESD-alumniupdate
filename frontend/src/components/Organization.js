import React, { useState } from 'react'

/*
  This component is used for rendering the "Bills" view which contains each Bill of the Student
  Each Bill is its own component
  
  bills: Collection of bills of the given Student
  payBill: Method that uses the axios service to pay the specified bill, i.e. send a DELETE request
*/
const Organization = ({ updateorg }) => {  
  // If there's no Bills for the student, then render nothing. Can instead render a message like "No Bills Remaining"

  const [ degree, setDegree ] = useState('')
  const [ passingyear, setPassingyear ] = useState('')
  const [ joiningyear, setJoiningyear ] = useState('')
  const [ collegename, setCollegename ] = useState('')
  const [ address, setAddress ] = useState('')
  const educationUpdateHandle = (event) => {
    // Preventing default submission of the form to the action attribute URL
    event.preventDefault()

    const details = {
      degree,passingyear,joiningyear,collegename,address
    }

    // Calling startLogin with the provided credentials that will make a call to the backend
    update(details)

    // Reset the form state, i.e. the text that's on the username and password text boxes to empty strings
    setDegree('')
    setPassingyear('')
    setJoiningyear('')
    setCollegename('')
    setAddress('')
  }
  return (
    <div>
    <h3>Update Education Details</h3>
    <form onSubmit={educationUpdateHandle} id='edu-form'>
      <input 
        type='degree'
        placeholder='Degree'
        // Note that the text that's displayed on the textbox (value attribute) is controlled by the email state
        value={degree}
        // onChange event handler
        // When you type something on the textbox, the onChange event handler will be triggered
        // This event handler as written below, updates the email state with what's being typed by the user
        // Because a state has been updated, the form component will be re-rendered and you can see the updated input
        // on the screen, obviously this happens so fast that you cannot see it but this is the entire procedure
        onChange={event => setDegree(event.target.value)}
        id='degree'
        required
      />
        
      {/* Same as the above username input, except this one has the type password */}
      <input
        type='passingyear'
        placeholder='Passing year'
        value={passingyear}
        onChange={event => setPassingyear(event.target.value)}
        id='passingyear'
        required
      />

      <input
        type='joiningyear'
        placeholder='Joining year'
        value={joiningyear}
        onChange={event => setJoiningyear(event.target.value)}
        id='joiningyear'
        required
      />
      
      <input
        type='collegname'
        placeholder='College name'
        value={collegename}
        onChange={event => setCollegename(event.target.value)}
        id='collegename'
        required
      />

      <input
        type='address'
        placeholder='Address'
        value={address}
        onChange={event => setAddress(event.target.value)}
        id='address'
        required
      />
      {/* Submit button for the form */}
      <button type='submit' id='update-submit'>UPDATE</button>
    </form>
    </div>
  )
}

export default Organization