import Axios from "axios";

const API_URL = "http://localhost:8282/";
const service = (path, method = "GET", data) => {
  return Axios({
    url: API_URL + path,
    method,
    data,
  })
    .then((response) => response)
    .catch((error) => error);
};

export default service;
