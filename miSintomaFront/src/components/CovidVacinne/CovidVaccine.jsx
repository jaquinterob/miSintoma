import React, {useState, useEffect} from "react";
import "./CovidVaccine.scss";
import CovidVaccineTable from "../CovidVacinne/CovidVaccineTable";
import CovidVaccineData from "./utils/CovidVaccineData";
import AddCovidVaccineForm from "./AddCovidVaccineForm";
import EditCovidVaccineForm from "./EditCovidVaccineForm";
import service from "../../service";
import apiRoutes from "../../routes/apiRoutes/apiRoutes";

const CovidVaccine = () => {
  const [vaccine, setVaccine] = useState(CovidVaccineData);
  const [showLoading, setShowLoading] = useState(true);
  const [editing, setEditing] = useState(false);
  const [currentCovidVaccine, setCurrentCovidVaccine] = useState({
    id: null,
    nameVaccine: "",
    components: "",
    laboratory: "",
    expirationDate: "",
    clinicalData: "",
    vaccineBatch: "",
  });

  useEffect(() => {
    const fetchData = async () => {
      const result = await service(
        apiRoutes.VACCINE_BASE + apiRoutes.VACCINE_ALL,
        "GET"
      );
      setVaccine(result.data.vaccineList);
    };
    fetchData();
  }, []);

  const addCovidVaccine = async ({
    nameVaccine,
    components,
    laboratory,
    expirationDate,
    clinicalData,
    vaccineBatch,
  }) => {
    try {
      setShowLoading(true);
      const response = await service(
        apiRoutes.VACCINE_BASE + apiRoutes.VACCINE_ADD,
        "POST",
        {
          nameVaccine,
          components,
          laboratory,
          expirationDate,
          clinicalData,
          vaccineBatch,
        }
      );
      setVaccine([...vaccine, response.data]);
      setShowLoading(false);
    } catch (error) {
      setShowLoading(false);
      console.log(error);
    }
  };

  const deleteCovidVaccine = async (id) => {
    try {
      setShowLoading(true);
      setVaccine(vaccine.filter((covidVaccine) => covidVaccine.id !== id));
      await service(apiRoutes.VACCINE_BASE + apiRoutes.VACCINE_REMOVE, "POST", {
        id,
      });
      setShowLoading(false);
    } catch (error) {
      setShowLoading(false);
      console.log(error);
    }
  };

  const editRow = async ({
    nameVaccine,
    components,
    laboratory,
    expirationDate,
    clinicalData,
    vaccineBatch,
  }) => {
    setEditing(true);
    setCurrentEmployee({
      nameVaccine,
      components,
      laboratory,
      expirationDate,
      clinicalData,
      vaccineBatch,
    });
  };

  const updateCovidVaccine = async (
    id,
    {
      nameVaccine,
      components,
      laboratory,
      expirationDate,
      clinicalData,
      vaccineBatch,
    }
  ) => {
    try {
      setEditing(false);
      setShowLoading(true);
      setVaccine(
        vaccine.map((covidVaccine) =>
          covidVaccine.id === id
            ? {
                nameVaccine,
                components,
                laboratory,
                expirationDate,
                clinicalData,
                vaccineBatch,
              }
            : vaccine
        )
      );
      await service(apiRoutes.VACCINE_BASE + apiRoutes.VACCINE_UPDATE, "POST", {
        nameVaccine,
        components,
        laboratory,
        expirationDate,
        clinicalData,
        vaccineBatch,
      });
      setShowLoading(false);
    } catch (error) {
      setShowLoading(false);
      console.log(error);
    }
  };

  console.log("Entre pai")
  return (
    <div className="container">
      <h1>CRUD App with Hooks</h1>
      <div className="flex-row">
        <div className="flex-large">
          {editing ? (
            <>
              <h2>Edit Vaccine</h2>
              <EditCovidVaccineForm
                setEditing={setEditing}
                currentCovidVaccine={currentCovidVaccine}
                updateCovidVaccine={updateCovidVaccine}
              />
            </>
          ) : (
            <>
              <h2>Add Vaccine</h2>
              <AddCovidVaccineForm addCovidVaccine={addCovidVaccine} />
            </>
          )}
        </div>

        <div className="flex-large">
          <h2>View Vaccines</h2>
          <CovidVaccineTable
            vaccine={vaccine}
            deleteCovidVaccine={deleteCovidVaccine}
            editRow={editRow}
          />
        </div>
      </div>
    </div>
  );
};

export default CovidVaccine;
