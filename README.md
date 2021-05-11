# Covid19-Android

Android application for Covid-19 vaccination program.

## Description

At the start, the user sees the start menu with a sidebar and app bar option.<br><br>
<img src="https://user-images.githubusercontent.com/53277964/117832260-a12e0e80-b275-11eb-9665-4fca1bb9c220.jpg" width="148">

In the menu bar, there are two options: Statistics and Language change. The user can access the Language change via app bar.<br><br>
<img src="https://user-images.githubusercontent.com/53277964/117832644-f4a05c80-b275-11eb-93b6-420d65806472.jpg" width="148">
<img src="https://user-images.githubusercontent.com/53277964/117840812-c7a37800-b27c-11eb-9d6b-2605763ad45e.jpg" width="148">
<img src="https://user-images.githubusercontent.com/53277964/117833857-fb7b9f00-b276-11eb-87f8-4444ea862990.jpg" width="148">

In the next fragment, the app checks whether the user is suited to take the vaccine in the near future. If not, a suitable message is shown otherwise the app proceeds to take the user's info in the next fragment.<br><br>
<img src="https://user-images.githubusercontent.com/53277964/117835587-4a760400-b278-11eb-8185-d18dfd818023.jpg" width="148">

The info fragment takes the user's info and the chosen vaccine and passes it to the overview fragment using Safe Args plugin.<br><br>
<img src="https://user-images.githubusercontent.com/53277964/117836091-b22c4f00-b278-11eb-85e4-91723f8f79ba.jpg" width="148">
<img src="https://user-images.githubusercontent.com/53277964/117836180-c2442e80-b278-11eb-8fcb-71c2b5f52af7.jpg" width="148">

Overview fragment shows the inserted data and asks the user to confirm it.<br><br>
<img src="https://user-images.githubusercontent.com/53277964/117836789-2ebf2d80-b279-11eb-88cd-468caa4ea8d0.jpg" width="148">

The last fragment displays the date, time, and location for vaccination and also the simulated number of applicants. The sim number is incremented with a random integer in the range 0 to 3 included every five seconds. The counter continues to work in the background (when the app triggers onPause or onStop callbacks). The user can also share his successful registration for vaccination via some messaging app.<br><br>
<img src="https://user-images.githubusercontent.com/53277964/117837731-fc620000-b279-11eb-8828-7664855b2b9f.jpg" width="148">
<img src="https://user-images.githubusercontent.com/53277964/117837827-0edc3980-b27a-11eb-87f9-3dc1503f31b6.jpg" width="148">
<img src="https://user-images.githubusercontent.com/53277964/117837904-1f8caf80-b27a-11eb-8f3b-df43c05ece0b.jpg" width="148">







