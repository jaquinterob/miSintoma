import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';
import reportWebVitals from './reportWebVitals';
import HolaMundo from './components/HolaMundoExtendidoScript';
import Presentacional from './components/PresentacionalConstante';
import Statefull from './components/Statefull';
import Stateless from './components/Stateless';
import Button from './components/Button';
import GetGreeting from './components/GetGreeting';

ReactDOM.render(
  <React.StrictMode>
    <Presentacional />
    <Statefull />
    <Stateless />
    <HolaMundo />
    <Button />
    <GetGreeting />
  </React.StrictMode>,
  document.getElementById('root')
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
