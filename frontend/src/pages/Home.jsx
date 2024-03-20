import { useState } from 'react';
import React from 'react'
import ImageSlider from '../components/ImageSlider';
import '../assets/css/Home.css';
import BoatHouseCard from '../components/BoatHouseCard';
function Home(){
    const slides = [
        { image: "https://t4.ftcdn.net/jpg/05/84/31/57/360_F_584315730_hlgzu4Lzr8OtQgU0QerDDSroKtFqbRCf.jpg" },
        { image: "https://t4.ftcdn.net/jpg/00/93/72/15/360_F_93721520_PRHW9e77w1cPVReB0GZknG8TaEZb3dKI.jpg" },
        { image: "https://i.pinimg.com/originals/87/42/f0/8742f0d9ce3d21a71593c8d4c9f0c078.jpg" }
    ];
    const [sideBarHide, toggleSideBar]=useState(true);
    const handleFilterButton=()=>{
        toggleSideBar(!sideBarHide);
    }
    return (
        <>
        <div className="homepage-outer">
            <div className="filter-sidebar" style={{left:(sideBarHide)?"-18%":"0%",}}>
                <div className='filter-contents'>
                    <label className="filter-content-label">Destination</label>
                    <input className="filter-contents-calendar" type="text"></input>
                    <label className="filter-content-label">Check in</label>
                    <input className="filter-contents-calendar" type="datetime-local"></input>
                    <label className="filter-content-label">Check out</label>
                    <input className="filter-contents-calendar" type="datetime-local"></input>
                    <br/>
                    <br/>
                    <hr/>
                    Price: Low to High
                    <hr/>
                    Price: High to Low
                    <hr/>
                    Best rating
                    <hr/>
                </div>
                <button className="filter-sidebar-button" onClick={handleFilterButton}>FILTER</button>
            </div>
            <div className="boathouse-s-display" style={{width:(sideBarHide)?"98%":"80%",marginLeft:(sideBarHide)?"2%":"20%"}}>
            <ImageSlider slides={slides} autoPlay={true} />
            <BoatHouseCard/>
            <BoatHouseCard/>
            <BoatHouseCard/>
            <BoatHouseCard/>
            <BoatHouseCard/>
            <BoatHouseCard/>
            <BoatHouseCard/>
            <BoatHouseCard/>
            <BoatHouseCard/>
            <BoatHouseCard/>
            <BoatHouseCard/>
            <BoatHouseCard/>
            <BoatHouseCard/>
            <BoatHouseCard/>
            <BoatHouseCard/>
            <BoatHouseCard/>
            <BoatHouseCard/>
            <BoatHouseCard/>
            <BoatHouseCard/>
            <BoatHouseCard/>
            </div>
                
        </div>
        </>
    );
}
export default Home;