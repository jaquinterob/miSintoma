import Axios from "axios";
const API_URL = "http://localhost:8282/covid-vaccineAPI/";
const service = (path, method, data) => {
  return Axios({ url: API_URL + path, method, data })
    .then((response) => response)
    .catch((error) => error);
};

export default service;
