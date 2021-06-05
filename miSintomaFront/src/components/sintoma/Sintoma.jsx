import React, { useState, useEffect } from "react";
import "./Sintoma.scss";
import SintomaTable from "./SintomaTable";
import AddSintomaForm from "./AddSintomaForm";
import EditSintomaForm from "./EditSintomaForm";
import axios from "axios";

const Sintoma = () => {
  const SintomaData = [
    { id: 1, namesintoma: "Fiebre", Descripcion: "aumento de la temperatura corporal" },
    { id: 2, namesintoma: "Dolor de cabeza", Descripcion: "migrañas severas" },
    { id: 3, namesintoma: "Malestar", Descripcion: "malestar general" },
  ];
  const [sintomas, setSintomas] = useState(SintomaData);
  const [showLoading, setShowLoading] = useState(true);
  const apiUrl = "http://localhost:8282/sintomaAPI/";

  useEffect(() => {
    const fetchData = async () => {
      const result = await axios(apiUrl + "sintomagetall");
      setSintomas(result.data.sintomaList);
    };
    fetchData();
  }, []);



  const addSintoma = (sintoma) => {
    setShowLoading(true);
    const data = {
      id: sintoma.id,
      namesintoma: sintoma.namesintoma,
      descripcion: sintoma.descripcion,
     
    };
    axios
      .post(apiUrl + "addsintoma", data)
      .then((result) => {
        setSintomas([...sintomas, result.data]);
      })
      .catch((error) => setShowLoading(false));

    /*
    sintoma.id = sintomas.length + 1;
    setSintomas([...sintomas, sintoma]);

    const data = {
      id: parseInt(sintoma.id),
      namesintoma: sintoma.namesintoma,
      descripcion: sintoma.descripcion,
      
    };

    axios
      .post(apiUrl, data)
      .then((result) => {
        //props.history.push('/show/' + result.data._id)
        console.log("Consumo del Servicio 2");
        console.log(result);
      })
      .catch((error) => setShowLoading(false));
*/
  };

  const deleteSintoma = (id) => {
    setSintomas(sintomas.filter((sintoma) => sintoma.id !== id));
    const data = {
      id: id,
      namesintoma: "",
      descripcion: "",
      
    };
    axios
      .post(apiUrl + "sintomaremove", data)
      .then((result) => {
        //console.log(result);
      })
      .catch((error) => setShowLoading(false));
  };

  const [editing, setEditing] = useState(false);

  const initialFormState = {
    id: null,
    namesintoma: "",
    descripcion: "",
    
  };

  const [currentSintoma, setCurrentSintoma] = useState(initialFormState);

  const editRow = (sintoma) => {
    setEditing(true);
    setCurrentSintoma({
      id: sintoma.id,
      namesintoma: sintoma.namesintoma,
      descripcion: sintoma.descripcion,
      
    });
  };

  const updateSintoma = (id, updatedSintoma) => {
    setEditing(false);
    setSintomas(
      sintomas.map((sintoma) =>
        sintoma.id === id ? updatedSintoma : sintoma
      )
    );
    const data = {
      id: updatedSintoma.id,
      namesintoma: updatedSintoma.namesintoma,
      descripcion: updatedSintoma.descripcion,
      
    };
    axios
      .post(apiUrl + "updatesintoma", data)
      .then((result) => {
        //console.log("Updated");
      })
      .catch((error) => setShowLoading(false));
  };

  return (
    <div className="container">
      <h1>CRUD App with Hooks</h1>
      <div className="flex-row">
        <div className="flex-large">
          {editing ? (
            <div>
              <h2>Edit Sintoma</h2>
              <EditSintomaForm
                setEditing={setEditing}
                currentSintoma={currentSintoma}
                updateSintoma={updateSintoma}
              />
            </div>
          ) : (
            <div>
              <h2>Add sintoma</h2>
              <AddSintomaForm addSintoma={addSintoma} />
            </div>
          )}
        </div>

        <div className="flex-large">
          <h2>View Sintomas</h2>
          <SintomaTable
            sintomas={sintomas}
            deleteSintoma={deleteSintoma}
            editRow={editRow}
          />
        </div>
      </div>
    </div>
  );
};

export default Sintoma;


