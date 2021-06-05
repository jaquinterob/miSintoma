import React from "react";

const SintomaTable = (props) => (
  <table>
    <thead>
      <tr>
        <th>ID BD</th>
        <th>namesintoma</th>
        <th>descripcion</th>
      </tr>
    </thead>
    <tbody>
    {undefined !== props.sintomas && props.sintomas.length > 0 ? (
        props.sintomas.map((sintoma) => (
          <tr key={sintoma.id.toString()}>
            <td>{sintoma.id}</td>
            <td>{sintoma.namesintoma}</td>
            <td>{sintoma.descripcion}</td>
            <td>
              <button
                onClick={() => {
                  props.editRow(sintoma);
                }}
                className="button muted-button"
              >
                Edit
              </button>
              <button
                onClick={() => props.deleteSintoma(sintoma.id)}
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

