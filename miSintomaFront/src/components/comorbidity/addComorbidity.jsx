import React, { useState } from "react";
import {
  TextField,
  Button,
  Card,
  Typography,
  CircularProgress,
} from "@material-ui/core";
import styles from "./comorbidity.module.scss";

export default function AddComorbidity({ handlerCreate }) {
  const [newComorbidity, setNewComorbidity] = useState({ name: "", type: "" });
  const [isLoading, setLoading] = useState(false);
  const handleChange = (name) => (e) => {
    setNewComorbidity({ ...newComorbidity, [name]: e.target.value });
  };
  const handleClick = async () => {
    setLoading(true);
    await handlerCreate({
      ...newComorbidity,
      id: Math.floor(Math.random() * 100),
    });
    setNewComorbidity({});
    setLoading(false);
  };
  return (
    <Card classes={{ root: styles.card }}>
      <Typography variant="h4" gutterBottom>
        Crear comorbilidad
      </Typography>
      {isLoading ? (
        <CircularProgress />
      ) : (
        <div className={styles.mainContainer}>
          <div className={styles.container}>
            <TextField
              label="Nombre de la comorbilidad"
              variant="outlined"
              defaultValue={newComorbidity.name || ""}
              onChange={handleChange("name")}
            />
            <TextField
              label="Tipo de la comorbilidad"
              variant="outlined"
              defaultValue={newComorbidity.type || ""}
              onChange={handleChange("type")}
            />
          </div>
          <Button
            color="primary"
            variant="contained"
            fullWidth
            onClick={handleClick}
          >
            Crear
          </Button>
        </div>
      )}
    </Card>
  );
}
