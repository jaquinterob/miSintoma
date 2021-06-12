import React, { useState } from "react";

const AddCovidVaccineForm = ({ addCovidVaccine }) => {
  const INITIAL_FORM_STATE = {
    id: null,
    nameVaccine: "",
    components: "",
    laboratory: "",
    expirationDate: "",
    clinicalData: "",
    vaccineBatch: "",
  };
  const [covidVaccine, setCovidVaccine] = useState(INITIAL_FORM_STATE);

  const handleInputChange = (event) => {
    console.log(event.target);
    const { name, value } = event.target;
    setCovidVaccine({ ...covidVaccine, [name]: value });
  };

  return (
    <form
      onSubmit={(event) => {
        event.preventDefault();
        if (
          !covidVaccine.nameVaccine ||
          !covidVaccine.components ||
          !covidVaccine.laboratory ||
          !covidVaccine.expirationDate ||
          !covidVaccine.clinicalData ||
          !covidVaccine.vaccineBatch
        )
          return;

        addCovidVaccine(covidVaccine);
        setCovidVaccine(INITIAL_FORM_STATE);
      }}
    >
      <div className="container">
        <div className="row">
          <div className="col-md">
            <label className="mr-5" >Name Vaccine</label>
            <input
              type="text"
              name="nameVaccine"
              value={covidVaccine.nameVaccine}
              onChange={handleInputChange}
            />
          </div>

          <div className="col-md">
            <label className="mr-5">Components</label>
            <input
              type="text"
              name="components"
              value={covidVaccine.components}
              onChange={handleInputChange}
            />
          </div>

          <div className="col-md">
            <label className="mr-5">Laboratory</label>
            <input
              type="text"
              name="laboratory"
              value={covidVaccine.laboratory}
              onChange={handleInputChange}
            />
          </div>
        </div>

        <div className="row mt-3">
          <div className="col-md">
            <label className="mr-5" >Expiration Date</label>
            <input
              type="text"
              name="expirationDate"
              value={covidVaccine.expirationDate}
              onChange={handleInputChange}
            />
          </div>

          <div className="col-md">
            <label className="mr-5">Clinical Data</label>
            <input
              type="text"
              name="clinicalData"
              value={covidVaccine.clinicalData}
              onChange={handleInputChange}
            />
          </div>

          <div className="col-md">
            <label className="mr-5">Vaccine Batch</label>
            <input
              type="text"
              name="vaccineBatch"
              value={covidVaccine.vaccineBatch}
              onChange={handleInputChange}
            />
          </div>
        </div>
      </div>

      <button className="btn btn-warning">Add new vaccine</button>
    </form>
  );
};
export default AddCovidVaccineForm;
