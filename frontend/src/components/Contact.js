import React, { useState } from 'react'

/*
  This component is used for rendering the "Bills" view which contains each Bill of the Student
  Each Bill is its own component
  
  bills: Collection of bills of the given Student
  payBill: Method that uses the axios service to pay the specified bill, i.e. send a DELETE request
*/
const Contact = ({ update }) => {  
  // If there's no Bills for the student, then render nothing. Can instead render a message like "No Bills Remaining"

  const [ email, setEmail ] = useState('')
  const [ phno, setPhon ] = useState('')
  const contactupdateHandle = (event) => {
    // Preventing default submission of the form to the action attribute URL
    event.preventDefault()

    const details = {
      email,phno
    }

    // Calling startLogin with the provided credentials that will make a call to the backend
    update(details)

    // Reset the form state, i.e. the text that's on the username and password text boxes to empty strings
    setEmail('')
    setPhon('')
  }
  return (
    // <div className='m-5 p-2 rounded regular-shadow' id="bills">
    //   <h2 className='ml-2'>Your Bills</h2>
    //   <table cellPadding={10}>
    //     <tr>
    //       <th>Bill Description</th>
    //       <th>Bill Date</th>
    //       <th>Bill Amount</th>
    //     </tr>
    //     { 
    //       // Render each Bill as its separate component and for this you use the map() method
    //       // Whenever you use the map() method to render a collection of Components, React requires that you specify a unique
    //       // attribute of each component in this collection and for this case, we are using the id of each Bill as the key
    //       // for React to uniquely identify each Bill
    //       // We also pass on the Bill object that has to be rendered by the component and the payBill method that will
    //       // execute the payment
    //       bills.map(b =>
    //         <Bill
    //           bill={b}
    //           key={b.billId}
    //           payBill={payBill}
    //         /> 
    //       )
    //     }
    //   </table>
    // </div>
    <div>
    <h3>Update Contact Details</h3>
    <form onSubmit={contactupdateHandle} id='contact-form'>
      <input 
        type='email'
        placeholder='Email'
        // Note that the text that's displayed on the textbox (value attribute) is controlled by the email state
        value={email}
        // onChange event handler
        // When you type something on the textbox, the onChange event handler will be triggered
        // This event handler as written below, updates the email state with what's being typed by the user
        // Because a state has been updated, the form component will be re-rendered and you can see the updated input
        // on the screen, obviously this happens so fast that you cannot see it but this is the entire procedure
        onChange={event => setEmail(event.target.value)}
        id='email'
        required
      />
        
      {/* Same as the above username input, except this one has the type password */}
      <input
        type='phno'
        placeholder='Phone number'
        value={phno}
        onChange={event => setPhon(event.target.value)}
        id='phno'
        required
      />

      {/* Submit button for the form */}
      <button type='submit' id='update-submit'>UPDATE</button>
    </form>
    </div>
  )
}

export default Contact