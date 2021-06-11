import React from "react";

const CovidVaccineTable = ({ vaccine, deleteCovidVaccine, editRow }) => (
  <table>
    <thead>
      <tr>
        <th>nameVaccine</th>
        <th>components</th>
        <th>laboratory</th>
        <th>expirationDate</th>
        <th>clinicalData</th>
        <th>vaccineBatch</th>
      </tr>
    </thead>
    <tbody>
      {vaccine !== undefined && vaccine.length > 0 ? (
        vaccine.map((covidVaccine) => (
          <tr key={covidVaccine.id.toString()}>
            <td>{covidVaccine.nameVaccine}</td>
            <td>{covidVaccine.components}</td>
            <td>{covidVaccine.laboratory}</td>
            <td>{covidVaccine.expirationDate}</td>
            <td>{covidVaccine.clinicalData}</td>
            <td>{covidVaccine.vaccineBatch}</td>
            <td>
              <button
                onClick={() => {
                  editRow(covidVaccine);
                }}
                className="button muted-button"
              >
                Edit
              </button>
              <button
                onClick={() => deleteCovidVaccine(covidVaccine.id)}
                className="button muted-button"
              >
                Delete
              </button>
            </td>
          </tr>
        ))
      ) : (
        <tr>
          <td colSpan={3}>No Vaccine</td>
        </tr>
      )}
    </tbody>
  </table>
);

export default CovidVaccineTable;
