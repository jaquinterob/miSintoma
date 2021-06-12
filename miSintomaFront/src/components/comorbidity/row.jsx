import React, { useState } from "react";
import PropTypes from "prop-types";
import { Card, TextField, Button, Typography } from "@material-ui/core";
import styles from "./comorbidity.module.scss";

export default function Row({ id, name, type, handleEdit, handleRemove }) {
  const [edit, setEdit] = useState(false);
  const [comorbidityEditable, setComorbidityEditable] = useState({
    id,
    name,
    type,
  });

  const handlerChangeEditableBool = () => {
    if (edit) {
      setEdit(false);
      handleEdit(comorbidityEditable);
    } else {
      setEdit(true);
    }
  };

  const handleChangeEditable = (name) => (e) => {
    setComorbidityEditable({ ...comorbidityEditable, [name]: e.target.value });
  };

  return (
    <Card classes={{ root: styles.cardRow }}>
      {edit ? (
        <TextField
          defaultValue={name}
          onChange={handleChangeEditable("name")}
        />
      ) : (
        <Typography variant="body1">{name}</Typography>
      )}
      <Typography variant="body1"> - </Typography>
      {edit ? (
        <TextField
          defaultValue={type}
          onChange={handleChangeEditable("type")}
        />
      ) : (
        <Typography variant="body1">{type}</Typography>
      )}
      <Button
        variant="contained"
        color="primary"
        onClick={handlerChangeEditableBool}
      >
        {edit ? "guardar" : "editar"}
      </Button>
      <Button
        variant="contained"
        color="secondary"
        onClick={() => handleRemove(id)}
      >
        remover
      </Button>
    </Card>
  );
}

Row.propTypes = {
  id: PropTypes.number,
  name: PropTypes.string,
  type: PropTypes.string,
  handleEdit: PropTypes.func,
  handleRemove: PropTypes.func,
};
