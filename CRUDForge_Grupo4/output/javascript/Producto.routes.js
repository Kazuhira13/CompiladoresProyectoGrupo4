const express = require('express');
const router = express.Router();

const ejemploProducto = {
  id: '',
  nombre: '',
  precio: 0,
  stock: 0,
  categoria: 0
};

router.get('/producto', (req, res) => res.json([ejemploProducto]));
router.post('/producto', (req, res) => res.json(req.body));
router.put('/producto/:id', (req, res) => res.json(req.body));
router.delete('/producto/:id', (req, res) => res.json({ deleted: req.params.id }));

module.exports = router;
