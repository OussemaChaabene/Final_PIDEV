<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;
use Symfony\Component\Serializer\Annotation\Groups;
use Symfony\Component\Validator\Constraints as Assert;

/**
 * Seance
 *
 * @ORM\Table(name="seance")
 * @ORM\Entity
 */
class Seance
{
    /**
     * @var int
     * @Groups("post:read")
     * @ORM\Column(name="id_seance", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idSeance;

    /**
     * @var \DateTime
     * @Assert\NotBlank (message ="la date ne doit pas etre vide")
     * #[Assert\GreaterThan('now')]
     * @Groups("post:read")
     * @ORM\Column(name="date", type="datetime", nullable=false)
     */
    private $date;

    /**
     * @var string
     * @Groups("post:read")
     * @Assert\NotBlank (message ="le type de seance ne doit pas etre vide")
     * @ORM\Column(name="type_seance", type="string", nullable=false)
     */
    private $typeSeance;

    public function getIdSeance(): ?int
    {
        return $this->idSeance;
    }

    public function getDate(): ?\DateTimeInterface
    {
        return $this->date;
    }

    public function setDate(\DateTimeInterface $date): self
    {
        $this->date = $date;

        return $this;
    }

    public function getTypeSeance(): ?string
    {
        return $this->typeSeance;
    }

    public function setTypeSeance(string $typeSeance): self
    {
        $this->typeSeance = $typeSeance;

        return $this;
    }
    public function __construct()
    {
        $this->date = new \DateTime('now');
    }

}
