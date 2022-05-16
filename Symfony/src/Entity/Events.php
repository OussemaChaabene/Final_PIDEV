<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;
use Symfony\Component\Serializer\Annotation\Groups;
use Symfony\Component\Validator\Constraints as Assert;

/**
 * Events
 *
 * @ORM\Table(name="events")
 * @ORM\Entity
 */
class Events
{
    /**
     * @var int
     * @Groups("post:read")
     * @ORM\Column(name="idEven", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $ideven;

    /**
     * @var \DateTime
     * @Assert\NotBlank (message ="la date ne doit pas etre vide")
     * @Groups("post:read")
     * @ORM\Column(name="dateEven", type="date", nullable=false)
     */
    private $dateeven;

    /**
     * @var string
     * @Assert\NotBlank (message ="la description ne doit pas etre vide")
     * @Groups("post:read")
     * @ORM\Column(name="descri", type="string", length=255, nullable=false)
     */
    private $descri;

    /**
     * @var string
     * @Assert\NotBlank (message ="le nom ne doit pas etre vide")
     * @Groups("post:read")
     * @ORM\Column(name="nom", type="string", length=255, nullable=false)
     */
    private $nom;

    /**
     * @var int
     * @Assert\NotBlank (message ="le prix ne doit pas etre vide")
     * @Groups("post:read")
     * @ORM\Column(name="prix", type="integer", nullable=false)
     */
    private $prix;

    public function getIdeven(): ?int
    {
        return $this->ideven;
    }

    public function getDateeven(): ?\DateTimeInterface
    {
        return $this->dateeven;
    }

    public function setDateeven(\DateTimeInterface $dateeven): self
    {
        $this->dateeven = $dateeven;

        return $this;
    }

    public function getDescri(): ?string
    {
        return $this->descri;
    }

    public function setDescri(string $descri): self
    {
        $this->descri = $descri;

        return $this;
    }

    public function getNom(): ?string
    {
        return $this->nom;
    }

    public function setNom(string $nom): self
    {
        $this->nom = $nom;

        return $this;
    }

    public function getPrix(): ?int
    {
        return $this->prix;
    }

    public function setPrix(int $prix): self
    {
        $this->prix = $prix;

        return $this;
    }

    public function __toString()
    {
        return $this->nom;
        return $this->ideven;
    }


}
