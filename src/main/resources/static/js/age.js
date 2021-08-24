(()=>
{
    let birthDayCtrl=document.querySelector("#user_birthday")
    let userAge=document.querySelector("#user_age");
    birthDayCtrl.addEventListener("blur",(evt => {
        let birthDay = evt.currentTarget.value;
        let birth_date = new Date(birthDay)
        let today = new Date()
        let age = (today - birth_date) /(1000*60*60*24*365.25);
        if(age < 0)
            alert("Invalid birthday!")
        else
            userAge.value=age.toFixed(0);
    }))
})();

