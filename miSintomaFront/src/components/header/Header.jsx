import React from "react";
import "./Header.scss";
import { Link } from "react-router-dom";
import logo from "../../assets/icon/vaccine.png";
import userIcon from "../../assets/icon/user.png";
import localRoutes from "../../routes/localRoutes/localRoutes";

const Header = () => (
  <header className="header">
    <Link to={localRoutes.BASE}>
      <img className="header__img" src={logo} alt="Logo" />
    </Link>

    <div className="header__menu">
      <div className="header__menu--profile sidebar-header">
        <img className="header__img" src={userIcon} alt="user_icon" />
        <p className="text__menu">Menu</p>
      </div>
      <ul>
        <li>
          <Link to={localRoutes.BASE}>Home</Link>
        </li>
        <li>
          <Link to={localRoutes.BASE + localRoutes.VACCINE}>Vacuna Covid</Link>
        </li>
        <li>
          <Link to={localRoutes.BASE + localRoutes.SYMPTOM}>Sintoma</Link>
        </li>
        <li>
          <Link to={localRoutes.BASE + localRoutes.COMORBIDITY}>
            Comorbilidad
          </Link>
        </li>
      </ul>
    </div>
  </header>
);
export default Header;
