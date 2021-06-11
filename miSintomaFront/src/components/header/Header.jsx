import React from "react";
import "./Header.scss";
import { Link } from "react-router-dom";
import logo from "../../assets/icon/vaccine.png";
import localRoutes from "../../routes/localRoutes/localRoutes";

const Header = () => (
  <header className="header">
    <Link to={localRoutes.BASE}>
      <img className="header__img" src={ logo } alt="Logo" />
    </Link>

    <div className="header__menu">
      <div className="header__menu--profile">
        <img src="{ userIcon }" alt="user_icon" />
        <p>Menu</p>
      </div>
      <ul>
        <li>
          <Link to={localRoutes.BASE}>Home</Link>
        </li>
        <li>
          <Link to={localRoutes.BASE + localRoutes.VACCINE}>
            Link MiSintoma
          </Link>
        </li>
        <li>
          <Link to={localRoutes.BASE + localRoutes.VACCINE}>Vacuna Covid</Link>
        </li>
        <li>
          <Link to={localRoutes.BASE + localRoutes.SYMPTOM}>
            Link Vieja Escuela
          </Link>
        </li>
        <li>
          <Link to={localRoutes.BASE + localRoutes.SYMPTOM}>Sintoma</Link>
        </li>
      </ul>
    </div>
  </header>
);
export default Header;
