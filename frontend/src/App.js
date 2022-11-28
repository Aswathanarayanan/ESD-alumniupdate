import { useState, useEffect } from 'react'

import loginService from './services/login'
import billService from './services/bills'

import Notification from './components/Notification'
import LoginForm from './components/LoginForm'
import NavBar from './components/NavBar'
import Bills from './components/Bills'
import ContactUpdate from './components/Contact'
import ContactService from './services/contact'
import Education from './components/Education'
import Educationservice from './services/education'
import Organization from './components/Organization'
import OrglistService from './services/orglist'
import OrganizationService from './services/oraganisation'
import Orgupdateservice from './services/organisationupdate'
import Organisationupdate from './components/Organisationupdate'
import Organisationdelete from './components/Organisationdelete'


const App = () => {
  // user state will store the logged in user object, if no login has been done yet then it will be null
  const [ user, setUser ] = useState(null)

  // Will store the bills of the logged in user
  const [ bills, setBills ] = useState([])

  // These states are used to control the notifications that show up at the top of the screen for events like 
  // login, signup, watchlist creation, etc.
  const [ notification, setNotification ] = useState(null)
  const [ notificationType, setNotificationType ] = useState(null)
  const [orglist , setOrglist] = useState(null)
  const [orgupdatelist , setupdatelist] = useState(null)
  // Create a notification at the top of the screen with given message for 10 seconds 
  // Notifications are of two types, "error" and "success"
  // The appearance of these two notifications can be adjusted via the index.css file
  const notificationHandler = (message, type) => {
    setNotification(message)
    setNotificationType(type)

    setTimeout(() => {
      setNotificationType(null)
      setNotification(null)
    }, 3000)
  }

  // Function that handles login of users
  const handleLogin = async (credentials) => {
    try {
      const userObject = await loginService.login(credentials)
      setUser(userObject)
      window.localStorage.setItem('loggedInUser', JSON.stringify(userObject))
      
      notificationHandler(`Logged in successfully as ${userObject.email}`, 'success')
      
      const orglistObject = await OrglistService.orglist()
      setOrglist(orglistObject)
      window.localStorage.setItem('orgs', JSON.stringify(orglistObject))
      
      notificationHandler(`Logged in successfully as ${orglistObject[0].name}`, 'success')

      const orgupdatelistObject = await Orgupdateservice.orgupd(userObject)
      setupdatelist(orgupdatelistObject)
      window.localStorage.setItem('orgsupd', JSON.stringify(orgupdatelistObject))
      //notificationHandler(`Logged in successfully as ${orgupdatelistObject[0].position}`, 'success')

    }
    catch (exception) {
      notificationHandler(`Log in failed, check username and password entered`, 'error')
    }
  }

  const handleContactupdate = async (details) => {
    try {
      //window.localStorage.setItem('loggedInUser', JSON.stringify(user))
      const updateresponse = await ContactService.update(details,user)
      // setUser(userObject)
      notificationHandler(`Contact updated successfully response ${updateresponse}`, 'success')
     
    }
    catch (exception) {
      notificationHandler(`Update failed`, 'error')
    }
  }

  const handleEducationupdate = async (details) => {
    try {
      //window.localStorage.setItem('loggedInUser', JSON.stringify(user))
      const updateresponse = await Educationservice.updateedu(details,user)
      // setUser(userObject)
      notificationHandler(`Education updated successfully response ${updateresponse}`, 'success')
     
    }
    catch (exception) {
      notificationHandler(`Update failed`, 'error')
    }
  }

  const handleOrganisationAdd = async (details,oraganisation) => {
    //notificationHandler(`Update ${oraganisation}`, 'success')
    try {
      const updateresponse = await OrganizationService.orgadd(details,user,oraganisation)
      // setUser(userObject)
      notificationHandler(`Organisation updated successfully response ${updateresponse}`, 'success')
      
      const orgupdatelistObject = await Orgupdateservice.orgupd(user)
      setupdatelist(orgupdatelistObject)
      window.localStorage.setItem('orgsupd', JSON.stringify(orgupdatelistObject))
      notificationHandler(`Logged in successfully as ${orgupdatelistObject[0].position}`, 'success')

    }
    catch (exception) {
      notificationHandler(`Update failed ${oraganisation}`, 'error')
    }
  }

  const handleOrganisationupd = async (details,oraganisation) => {
    //notificationHandler(`Update ${oraganisation}`, 'success')
    try {
      const updateresponse = await OrganizationService.orgupd(details,oraganisation)
      // setUser(userObject)
      notificationHandler(`Organisation updated successfully response ${updateresponse}`, 'success')
     
    }
    catch (exception) {
      notificationHandler(`Update failed ${oraganisation}`, 'error')
    }
  }

  const handleOrganisationdelete = async (oraganisation) => {
    //notificationHandler(`Update ${oraganisation}`, 'success')
    try {
      const updateresponse = await OrganizationService.orgdel(oraganisation)
      // setUser(userObject)
      notificationHandler(`Organisation updated successfully response ${updateresponse}`, 'success')
      
      const orgupdatelistObject = await Orgupdateservice.orgupd(user)
      setupdatelist(orgupdatelistObject)
      window.localStorage.setItem('orgsupd', JSON.stringify(orgupdatelistObject))
      notificationHandler(`Logged in successfully as ${orgupdatelistObject[0].position}`, 'success')
    }
    catch (exception) {
      notificationHandler(`Update failed ${oraganisation}`, 'error')
    }
  }
  // Function that pays a bill using the billObject that is passed to the function
  const payBill = async (billObject) => {
    try {
      // Call payBill() at the backend 
      await billService.payBill(billObject)

      // On successful completion of the above method, iterate through all the bills and only retain those bills
      // which don't have ID equal to the billObject's ID, i.e. the ID of the bill that's just been paid/deleted
      setBills(bills.filter(bill => bill.billId !== billObject.billId))

      notificationHandler(`Successfully paid the "${billObject.description}" bill`, 'success')
    }
    catch (exception) {
      notificationHandler(`Failed to pay the "${billObject.description}" bill successfully`, 'error')
    }
  }

  
  // Effect Hook that fetches a user's bills
  // If "user" state changes, then the new bills must be fetched.
  // This is why "user" is part of the dependency array of this hook
  // MIGHT HAVE TO CHANGE THIS LATER TO PROMISE CHAINING IF IT FAILS
  useEffect(() => {
      async function fetchData() {
        if (user) {
          const bills = await billService.getUserBills(user)
          setBills(bills)
        }
      }
      fetchData()
  }, [user])


  // Effect Hook that parses the local storage for 'loggedInUser' and sets the "user" state if a valid match is found
  // This enables user to login automatically without having to type in the credentials. Caching the login if you will.
  useEffect(() => {
    const loggedInUser = window.localStorage.getItem('loggedInUser')
    if (loggedInUser)
      setUser(JSON.parse(loggedInUser))

    const orgs = window.localStorage.getItem('orgs')
    if(orgs)
      setOrglist(JSON.parse(orgs))

    const orgsupd = window.localStorage.getItem('orgsupd')
    if(orgsupd)
      setOrglist(JSON.parse(orgsupd))

  }, [])

  return (
    <div>
      {/* Header of the page */}
      <div className='text-center page-header p-2 regular-text-shadow regular-shadow'>
          <div className='display-4 font-weight-bold'>
            Academia - Alumni
          </div>
      </div>
      
      {/* Notification component that will render only when the notification state is not null */}
      <Notification notification={notification} type={notificationType} />

      {
        /* Show Login form when no login has happened */
        user === null && 
        <LoginForm startLogin={handleLogin}/>
      }

      {
        /* Show NavBar when login has happened */
        user !== null && 
        <NavBar user={user} setUser={setUser}/>
      } 

      {
        /* Show updates for the User when loggedin */
        // user !== null &&
        // <Bills
        //   bills={bills}
        //   payBill={payBill}
        // />
      }
      {
        /* Show updates for the User when loggedin */
        user !== null &&
        <ContactUpdate update={handleContactupdate}
          />
      }
      {
        /* Show updates for the User when loggedin */
        user !== null &&
        <Education update={handleEducationupdate}
          />
      }
      {
        /* Show updates for the User when loggedin */
        user !== null &&
        <Organization updateorg={handleOrganisationAdd} list={orglist}
          />
      }
      {
        /* Show updates for the User when loggedin */
        user !== null &&
        <Organisationupdate orgupdate={handleOrganisationupd} list={orgupdatelist}
          />
      }
      {
        /* Show updates for the User when loggedin */
        user !== null &&
        <Organisationdelete orgdelete={handleOrganisationdelete} list={orgupdatelist}
          />
      }
    </div>
  )
}

export default App;
