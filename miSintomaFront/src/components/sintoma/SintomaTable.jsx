import React from "react";

const SintomaTable = ({ sintomas, deleteSintoma, editRow }) => (
  <table>
    <thead>
      <tr>
        <th>ID BD</th>
        <th>namesintoma</th>
        <th>descripcion</th>
      </tr>
    </thead>
    <tbody>
      {sintoma && sintomas.length > 0 ? (
        sintomas.map((sintoma) => (
          <tr key={sintoma.id.toString()}>
            <td>{sintoma.id}</td>
            <td>{sintoma.namesintoma}</td>
            <td>{sintoma.descripcion}</td>
            <td>
              <button
                onClick={() => {
                  editRow(sintoma);
                }}
                className="button muted-button"
              >
                Edit
              </button>
              <button
                onClick={() => deleteSintoma(sintoma.id)}
                className="button muted-button"
              >
                Delete
              </button>
            </td>
          </tr>
        ))
      ) : (
        <tr>
          <td colSpan={3}>No sintoma</td>
        </tr>
      )}
    </tbody>
  </table>
);

export default SintomaTable;
