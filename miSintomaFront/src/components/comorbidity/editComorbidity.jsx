import React from "react";
import PropTypes from "prop-types";
import { Card, Typography } from "@material-ui/core";
import Row from "./row";
import styles from "./comorbidity.module.scss";

export default function EditComorbidity({ comorbidities, setComorbidities }) {
  const handleEdit = (row) => {
    const newComorbidities = [...comorbidities];
    const index = newComorbidities.findIndex(
      (comorbidity) => comorbidity.id === row.id
    );
    newComorbidities[index] = row;
    setComorbidities(newComorbidities);
  };

  const handleRemove = (id) => {
    const newComorbidities = comorbidities.filter(
      (comorbidity) => comorbidity.id !== id
    );
    setComorbidities(newComorbidities);
  };

  return (
    <Card classes={{ root: styles.card }}>
      <Typography variant="h4" gutterBottom>
        Comorbilidades
      </Typography>
      <div className="list">
        {comorbidities.map((comorbidity) => (
          <Row
            key="row-key"
            id={comorbidity.id}
            name={comorbidity.name}
            type={comorbidity.type}
            handleEdit={handleEdit}
            handleRemove={handleRemove}
          />
        ))}
      </div>
    </Card>
  );
}

EditComorbidity.propTypes = {
  comorbidities: PropTypes.number,
  setComorbidities: PropTypes.func,
};
